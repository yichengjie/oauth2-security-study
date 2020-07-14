package com.yicj.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//由于Spring boot starter自动装配机制，
// 这里无需使用@EnableWebSecurity，WebSecurityConfig内容如下
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
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
