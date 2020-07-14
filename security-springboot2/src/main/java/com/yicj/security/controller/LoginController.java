package com.yicj.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    /**
     * 测试资源1
     * @param session
     * @return
     */
    @GetMapping(value = "/r/r1", produces = {"text/plain;charset=utf-8"})
    public String r1(HttpSession session){
        String username = getUsername() ;
        return username + " 访问资源1";
    }


    /**
     * 测试资源2
     * @param session
     * @return
     */
    @GetMapping(value = "/r/r2", produces = {"text/plain;charset=utf-8"})
    public String r2(HttpSession session){
        String username = getUsername() ;
        return username + "访问资源2";
    }

    @RequestMapping(value = "/login-success", produces = {"text/plain;charset=utf-8"})
    public String loginSuccess(){
        String username = getUsername() ;
        return username + " 登录成功" ;
    }


    /**
     * 获取当前登录用户名
     * @return
     */
    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()){
            return null ;
        }
        Object principal = authentication.getPrincipal();
        String username = null ;
        if (UserDetails.class.isAssignableFrom(principal.getClass())){
            username = ((UserDetails)principal).getUsername() ;
        }else {
            username = principal.toString() ;
        }
        return username ;
    }
}
