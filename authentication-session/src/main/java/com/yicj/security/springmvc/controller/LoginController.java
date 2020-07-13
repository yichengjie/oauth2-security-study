package com.yicj.security.springmvc.controller;

import com.yicj.security.springmvc.model.AuthenticationRequest;
import com.yicj.security.springmvc.model.UserDetails;
import com.yicj.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String login(AuthenticationRequest authenticationRequest){
        UserDetails userDetails = authenticationService.authentication(authenticationRequest);
        return userDetails.getFullname()+ "login success";
    }
}
