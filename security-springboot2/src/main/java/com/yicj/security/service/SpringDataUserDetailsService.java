package com.yicj.security.service;

import com.yicj.security.dao.UserDao;
import com.yicj.security.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private UserDao userDao ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //登录账号
        log.info("username={}", username);
        //根据账号去数据库查询...
        UserDto user = userDao.getUserByUsername(username);
        if (user == null){
            return null ;
        }
        // 查询用户权限
        List<String> permissions = userDao.findPermissionsByUserId(user.getId());
        String [] pers = new String[permissions.size()] ;
        permissions.toArray(pers) ;
        // 创建userDetails
        UserDetails userDetails = User.withUsername(user.getFullname()).password(user.getPassword()).authorities(pers).build();
        return userDetails;
    }
}
