package com.yicj.distributed.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * ClassName: ResourceServerConfig
 * Description: TODO(描述)
 * Date: 2020/7/15 11:20
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Configuration
public class ResourceServerConfig  {

    public static final String RESOURCE_ID = "res1" ;

    // 统一认证服务（UUA）资源拦截
    @Configuration
    @EnableResourceServer
    public class UUAServerConfig extends ResourceServerConfigurerAdapter{

        @Autowired
        private TokenStore tokenStore ;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.tokenStore(tokenStore)
                    .resourceId(RESOURCE_ID)
                    .stateless(true) ;
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/uua/**").permitAll() ;
        }
    }

    //订单服务
    @Configuration
    @EnableResourceServer
    public class OrderServiceConfig extends ResourceServerConfigurerAdapter{

        @Autowired
        private TokenStore tokenStore ;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.tokenStore(tokenStore)
                    .resourceId(RESOURCE_ID)
                    .stateless(true) ;
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/order/**")
                    .access("#oauth2.hasScope('ROLE_API')") ;
        }
    }

}
