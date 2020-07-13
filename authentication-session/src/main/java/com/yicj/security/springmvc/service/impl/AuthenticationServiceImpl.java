package com.yicj.security.springmvc.service.impl;

import com.yicj.security.springmvc.model.AuthenticationRequest;
import com.yicj.security.springmvc.model.UserDetails;
import com.yicj.security.springmvc.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: AuthenticationServiceImpl
 * Description: TODO(描述)
 * Date: 2020/7/13 21:25
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private Map<String, UserDetails> userMap = new HashMap<>();
    {
        userMap.put("zhangsan",new UserDetails("1010","zhangsan","123","张三","133443"));
        userMap.put("lisi",new UserDetails("1011","lisi","456","李四","144553"));
    }

    @Override
    public UserDetails authentication(AuthenticationRequest authenticationRequest) {
        if(authenticationRequest == null
                || StringUtils.isEmpty(authenticationRequest.getUsername())
                || StringUtils.isEmpty(authenticationRequest.getPassword())){
            throw new RuntimeException("username or password not empty");
        }
        UserDetails userDto = getUserDto(authenticationRequest.getUsername());
        if(userDto == null){
            throw new RuntimeException("username is not exist");
        }
        if(!authenticationRequest.getPassword().equals(userDto.getPassword())){
            throw new RuntimeException("username or password error !");
        }
        return userDto;
    }

    public UserDetails getUserDto(String username){
        return userMap.get(username);
    }

}
