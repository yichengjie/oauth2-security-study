package com.yicj.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 由于Spring boot starter自动装配机制，
// 这里无需使用@EnableWebMvc与@ComponentScan，WebConfig如下
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 默认url路径跳转到/login，此url为spring security提供
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");
    }

}
