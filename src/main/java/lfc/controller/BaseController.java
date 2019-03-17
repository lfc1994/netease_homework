package lfc.controller;

import lfc.service.AccountService;
import lfc.service.ProductService;
import lfc.service.UserService;
import lfc.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @Autowired
    public ProductService productService;
    @Autowired
    public UserService userService;
    @Autowired
    public FileUtil fileUtil;
    @Autowired
    public AccountService accountService;
    /**
     * 全局异常处理
     */
    @ExceptionHandler
    public String handleException(HttpServletRequest request, Exception exception) {
        exception.printStackTrace();
        return "500";
    }
}
