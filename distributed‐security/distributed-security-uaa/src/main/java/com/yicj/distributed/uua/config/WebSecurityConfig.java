package com.yicj.distributed.uua.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//由于Spring boot starter自动装配机制，
// 这里无需使用@EnableWebSecurity，WebSecurityConfig内容如下
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    //Spring Security可以通过 http.authorizeRequests() 对web请求进行授权保护
    //Spring Security使用标准Filter建立了对web请求的拦截，最终实现对资源的授权访问
    // http.authorizeRequests() 对web资源进行授权保护
    // 从Spring Security2.0版本开始支持服务层方法的安全性的支持（@PreAuthorize,@PostAuthorize, @Secured）
    // 我们可以使用@EnableGlobalMethodSecurity启用基于注解的安全性
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/r/r1").hasAuthority("p1")
                .antMatchers("/login*").permitAll()
                .anyRequest().authenticated()
                .and()
            //支持form表单认证，认证成功后转向/login-success
            .formLogin()
                .and()
            .csrf().disable()
        ;
    }
}