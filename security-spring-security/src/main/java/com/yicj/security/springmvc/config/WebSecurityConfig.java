package com.yicj.security.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * ClassName: WebSecurityConfig
 * Description: TODO(描述)
 * Date: 2020/7/14 9:13
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
// 在SpringApplicationInitializer的getRootConfigClasses()方法，添加WebSecurityConfig.class
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 配置用户信息服务
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager() ;
        manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password("123").authorities("p2").build());
        return manager ;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance() ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            //访问/r/r1资源的 url需要拥有p1权限
            .antMatchers("/r/r1").hasAuthority("p1")
            //访问/r/r2资源的 url需要拥有p2权限
            .antMatchers("/r/r2").hasAuthority("p2")
            // url匹配/r/**的资源，经过认证后才能访问
            .antMatchers("/r/**").authenticated()
            // 其他url完全开放
            .anyRequest().permitAll()
            .and()
            //支持form表单认证，认证成功后转向/login-success
            .formLogin().successForwardUrl("/login-success") ;
    }
}
