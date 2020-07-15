package com.yicj.distributed.uua.service;

import com.alibaba.fastjson.JSON;
import com.yicj.distributed.uua.dao.UserDao;
import com.yicj.distributed.uua.model.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        UserDTO user = userDao.getUserByUsername(username);
        if (user == null){
            return null ;
        }
        // 查询用户权限
        List<String> permissions = userDao.findPermissionsByUserId(user.getId());
        String[] perArray = permissions.toArray(new String[0]);
        // 创建userDetails
        //这里将user转为json,将整体存入userDetails
        String principal = JSON.toJSONString(user);
        //这里暂时使用静态数据
        UserDetails userDetails = User.withUsername(user.getUsername())
                .password(user.getPassword()).authorities(perArray).build();
        return userDetails;
    }
}
