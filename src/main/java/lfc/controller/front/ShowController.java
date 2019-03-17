package lfc.controller.front;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lfc.controller.BaseController;
import lfc.pojo.Account;
import lfc.pojo.Product;
import lfc.pojo.User;
import lfc.util.ProductUtil;
import lfc.util.ResponseMessage;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/")
public class ShowController extends BaseController {
    //
    @RequestMapping("")
    public String home(HttpServletRequest request,Model model) throws Exception {
                String type = request.getParameter("type");
                String cookies = request.getHeader("cookie");
                if (cookies ==null){
                    List<Product> products = productService.listALL();
                    model.addAttribute("products",products);
                    return "home";
                }
                String[] cookieArray = cookies.split(";");
                for (int i=0;i<cookieArray.length;i++){
                    String key = cookieArray[i].split("=")[0];
                    if ("userId".equals(key.trim())) {
                        int uid = Integer.valueOf(cookieArray[i].split("=")[1]);
                        User user = (User)userService.get(uid);
                        List<Account> accounts;
                        List<Product> products;
                        if ("superAdmin".equals(user.getGroup_())){
                            accounts = accountService.listALL();
                        }else {
                            accounts = accountService.getByUid(uid);
                        }
                         products = productService.listALL();
                            for (int pIndex=0;pIndex<products.size();pIndex++){
                                for (int aIndex=0;aIndex<accounts.size();aIndex++){
                                    if (products.get(pIndex).getId().equals(accounts.get(aIndex).getPid())){
                                        products.get(pIndex).setIsSold("true");
                                        break;
                                    }
                                }
                            }
                            model.addAttribute("products",products);
                        if(type ==null){
                            model.addAttribute("isALL",Integer.valueOf(1));
                        }else {
                            model.addAttribute("isALL",Integer.valueOf(0));

                        }
                        return "home";
                    }
                }
        List<Product> products = productService.listALL();
        model.addAttribute("products",products);
             return "home";
    }
    /**
     * 账单
     * */
    @RequestMapping("accountdetail")
    public String accountDetail (HttpServletRequest request, Model model) throws Exception{
        String cookies = request.getHeader("cookie");
        if (cookies ==null){
            return "redirect:/login";
        }
        String[] cookieArray = cookies.split(";");
        for (int i=0;i<cookieArray.length;i++){
            String key = cookieArray[i].split("=")[0];
            if ("userId".equals(key.trim())){
                int uid = Integer.valueOf(cookieArray[i].split("=")[1]);
                List<Account> accounts = accountService.getByUid(uid);
                if (accounts==null){
                    return "account";
                }
                if (accounts.size()==0){
                    return "account";
                }
                productService.fillAccountModel(model,accounts);
                return "account";
            }
        }
        return "account";
    }
    /**
     * 商品发布页面
     * */
    @RequestMapping("public")
    public String releaseProduct(Model model, HttpSession session){
        if (session.getAttribute("user") == null ){
            return "redirect:/";
        }
        return "public";
    }
    /**
     * 上传图片
     * */

    @RequestMapping("upload")
    @ResponseBody
    public ResponseMessage uploadImage(@RequestParam("file") MultipartFile multipartFile) throws Exception{
        ResponseMessage responseMessage = new ResponseMessage();
        if (multipartFile !=null){
            String picURL = fileUtil.saveImg(multipartFile, multipartFile.getOriginalFilename());
            responseMessage.setStatus(200);
            responseMessage.setResult(picURL);
            return responseMessage;
        }else {
            responseMessage.setStatus(201);
            return responseMessage;
        }
    }
    /**
     * 商品发布到后台
     * */
    @RequestMapping("publicSubmit")
    public String submitProduct(HttpServletRequest request, Model model)throws Exception{
        Product product = new Product();
        product.setName(request.getParameter("title"));
        product.setSummary(request.getParameter("summary"));
        product.setPic(request.getParameter("pic"));
        product.setImageURL(request.getParameter("image"));
        product.setFile(request.getParameter("file"));
        product.setDetail(request.getParameter("detail"));
        product.setNowPrice(BigDecimal.valueOf(Double.parseDouble(request.getParameter("price"))));
        if (productService.add(product)==1){
            model.addAttribute("pid",productService.lastOne());
        }
        return "publicOk";
    }
    /**
     * 编辑商品信息
     * */
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, Model model) throws Exception{
        Integer id = Integer.parseInt(request.getParameter("id"));
        Product product = (Product)productService.get(id);
        model.addAttribute("product",product);
        return "edit";
    }
    /**
     * 编辑商品信息后发布到后台
     */
    @RequestMapping("editSubmit")
    public String editSubmit(HttpServletRequest request,Model model) throws Exception{
        Integer id = Integer.parseInt(request.getParameter("id"));
        Product productOld = productService.getById(id);
        Product productNew = new Product();
        productNew.setId(id);
        productNew.setName(request.getParameter("title"));
        productNew.setSummary(request.getParameter("summary"));
        productNew.setPic(request.getParameter("pic"));
        productNew.setImageURL(request.getParameter("image"));
        productNew.setFile(request.getParameter("file"));
        productNew.setDetail(request.getParameter("detail"));
        productNew.setOriginalPrice(productOld.getNowPrice());
        productNew.setNowPrice(BigDecimal.valueOf(Double.parseDouble(request.getParameter("price"))));
        productService.update(productNew);
        model.addAttribute("pid",id);
        return "editOk";
    }





}
