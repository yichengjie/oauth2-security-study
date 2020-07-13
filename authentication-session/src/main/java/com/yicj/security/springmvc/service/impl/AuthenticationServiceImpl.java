package com.yicj.security.springmvc.service.impl;

import com.yicj.security.springmvc.model.AuthenticationRequest;
import com.yicj.security.springmvc.model.UserDto;
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
    private Map<String, UserDto> userMap = new HashMap<>();
    {
        userMap.put("zhangsan",new UserDto("1010","zhangsan","123","张三","133443"));
        userMap.put("lisi",new UserDto("1011","lisi","456","李四","144553"));
    }

    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        if(authenticationRequest == null
                || StringUtils.isEmpty(authenticationRequest.getUsername())
                || StringUtils.isEmpty(authenticationRequest.getPassword())){
            throw new RuntimeException("username or password not empty");
        }
        UserDto userDto = getUserDto(authenticationRequest.getUsername());
        if(userDto == null){
            throw new RuntimeException("username is not exist");
        }
        if(!authenticationRequest.getPassword().equals(userDto.getPassword())){
            throw new RuntimeException("username or password error !");
        }
        return userDto;
    }

    public UserDto getUserDto(String username){
        return userMap.get(username);
    }

}
