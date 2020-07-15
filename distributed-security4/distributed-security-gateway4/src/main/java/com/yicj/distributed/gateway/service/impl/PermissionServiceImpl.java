package com.yicj.distributed.gateway.service.impl;

import com.yicj.distributed.gateway.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.http.AccessTokenRequiredException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: PermissionServiceImpl
 * Description: TODO(描述)
 * Date: 2020/7/15 15:21
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        // 1. 调用远程服务查询权限信息（可以在服务器启动的时候加载好，这里获取）
        // 2. 根据1中的权限信息进行判断
        log.info("===> url: {}", request.getRequestURI() );
        log.info("===> authentication : {}", ReflectionToStringBuilder.toString(authentication));
        if(authentication instanceof AnonymousAuthenticationToken){
            throw new AccessTokenRequiredException(null) ;
        }
        return RandomUtils.nextInt() %2 ==0;
    }
}
