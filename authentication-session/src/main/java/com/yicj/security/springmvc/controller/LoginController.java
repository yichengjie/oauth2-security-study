package com.yicj.security.springmvc.controller;

import com.yicj.security.springmvc.model.AuthenticationRequest;
import com.yicj.security.springmvc.model.UserDto;
import com.yicj.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * ClassName: LoginController
 * Description: TODO(描述)
 * Date: 2020/7/13 21:28
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@RestController
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login",produces = {"text/plain;charset=UTF-8"})
    public String login(AuthenticationRequest authenticationRequest, HttpSession session){
        UserDto userDetails = authenticationService.authentication(authenticationRequest);
        //用户信息存入session
        session.setAttribute(UserDto.SESSION_USER_KEY,userDetails);
        return userDetails.getUsername()+ "login success";
    }

    @GetMapping(value = "login", produces = "text/plain;charset=utf-8")
    public String logout(HttpSession session){

        session.invalidate();
        return "退出成功" ;
    }

    @GetMapping(value = "/r/r1", produces = {"text/plain;charset=utf-8"})
    public String r1(HttpSession session){
        String fullname = null;
        Object userObj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if(userObj != null){
            fullname = ((UserDto)userObj).getFullname();
        }else{
            fullname = "匿名";
        }
        return fullname + "访问资源1";
    }


}
