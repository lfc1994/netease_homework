package lfc.controller.front;

import lfc.controller.BaseController;
import lfc.util.ProductUtil;
import lfc.util.ResponseMessage;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import lfc.annotation.Auth;
import lfc.annotation.Nullable;
import lfc.pojo.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserFrontController extends BaseController {

    @RequestMapping("login")
    public String login(@Nullable String refer, Model model, HttpSession session)
    {
        if (refer != null) {
            model.addAttribute("refer",refer);
        }
        if (session.getAttribute("user") != null ){
            return "redirect:/";
        }
        return "login";
    }
    @RequestMapping("loginIn")
    public String loginIn(String name , String password , Model model, HttpSession session, HttpServletResponse response){
        User userFromDB = userService.get(name,password);
        if(userFromDB == null){
            String msg = "用户名密码错误，请重试";
            model.addAttribute("msg",msg);
            return "login";
        }
        session.setAttribute("user",userFromDB);
        Cookie cookie = new Cookie("userId",userFromDB.getId().toString());
        response.addCookie(cookie);
        return "redirect:/";
    }
    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/login";
    }
    @RequestMapping("checkLogin")
    public String checkLogin(Model model,HttpSession session){
        String msg = session.getAttribute("user")!=null?"success":"fail";
        model.addAttribute("msg",msg);
        return "msg";
    }
    @Auth(User.Group.unLogin)
    @RequestMapping("noAuth")
    public String noAuth(Model model){
        String msg = "没有权限访问此页面";
        model.addAttribute("msg",msg);
        return "msg";
    }


    @RequestMapping("show")
    public String showProduct(HttpServletRequest request, Model model)throws Exception{
        Integer pid = Integer.valueOf(request.getParameter("id"));
        String isSold = request.getParameter("isSold");
        if ("true".equals(isSold)){
            model.addAttribute("isSold",isSold);
            String cookies = request.getHeader("cookie");
            if (cookies != null){
                String[] cookieArray = cookies.split(";");
                for (String cookie: cookieArray
                     ) {
                    String key = cookie.split("=")[0];
                    if ("userId".equals(key.trim())){
                     int uid = Integer.parseInt(cookie.split("=")[1]);
                     Account account = accountService.getByUidPid(uid,pid);
                     if (account != null){
                         Product product =productService.getById(pid);
                         product.setOriginalPrice(account.getPrice());
                         model.addAttribute("product",product);
                         model.addAttribute("pid",pid);
                         return "show";
                     }
                    }
                }
            }
        }
        Product product =productService.getById(pid);
        product.setOriginalPrice(BigDecimal.valueOf(-1));
        model.addAttribute("product",product);
        model.addAttribute("pid",pid);
        return "show";
    }

    /**
     * 购物车
     * */
    @RequestMapping("settleAccount")
    public String settleAccount(HttpServletRequest request,Model model)throws Exception{
        String cookies = request.getHeader("cookie");
        if (cookies==null){
            return "redirect:/login";
        }
        String[] cookieArray = cookies.split(";");
        for (int i=0;i<cookieArray.length;i++){
            String key = cookieArray[i].split("=")[0];
            if ("lfcproducts".equals(key.trim())){
                String jsonString = cookieArray[i].split("=")[1];
                jsonString = "{\"productUtils\" : "+jsonString+"}";
                ProductUtil productUtil = null;
                try {
                    JSONObject jsonObject = JSONObject.fromObject(jsonString);
                    productUtil = (ProductUtil) JSONObject.toBean(jsonObject,ProductUtil.class);
                } catch (Exception e) {
                    return "shoplist";
                }
                model.addAttribute("productList",productUtil.getProductUtils());
                return "shoplist";
            }
        }
        return "shoplist";
    }
    @RequestMapping("buy")
    @ResponseBody
    public ResponseMessage buy(@RequestBody List<ProductUtil> productUtilList, HttpServletRequest request)throws Exception{
        ResponseMessage responseMessage = new ResponseMessage();
        String cookies = request.getHeader("cookie");
        if (cookies == null){
            responseMessage.setMessage("cookie is null");
            responseMessage.setCode(202);
            return responseMessage;
        }
        String[] cookieArray = cookies.split(";");
        for (int i=0;i<cookieArray.length;i++){
            String key = cookieArray[i].split("=")[0];
            if ("userId".equals(key.trim())) {
                int uid = Integer.valueOf(cookieArray[i].split("=")[1]);
                accountService.addBatch(productUtilList,uid);
                responseMessage.setCode(200);
                responseMessage.setMessage("OK");
                return responseMessage;
            }
        }
        responseMessage.setCode(202);
        responseMessage.setMessage("haven't insert into database account");
        return responseMessage;
    }

}
