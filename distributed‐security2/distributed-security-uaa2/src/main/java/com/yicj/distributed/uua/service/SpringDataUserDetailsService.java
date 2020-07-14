package com.yicj.distributed.uua.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * ClassName: SpringDataUserDetailsService
 * Description: TODO(描述)
 * Date: 2020/7/14 12:41
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Slf4j
@Service
public class SpringDataUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //登录账号
        log.info("username={}", username);
        //根据账号去数据库查询...
        //这里暂时使用静态数据
        UserDetails userDetails =
                User.withUsername(username).password(new BCryptPasswordEncoder().encode("123")).authorities("p1").build();
        return userDetails;
    }
}
