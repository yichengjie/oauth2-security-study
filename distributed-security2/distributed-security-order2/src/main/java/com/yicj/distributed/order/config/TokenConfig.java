package com.yicj.distributed.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * ClassName: TokenConfig
 * Description: TODO(描述)
 * Date: 2020/7/14 21:59
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Configuration
public class TokenConfig {

    private String SIGNING_KEY = "uua123" ;


    //在uaa中配置jwt令牌服务，即可实现生成jwt格式的令牌
    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(accessTokenConverter());
    }


    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter() ;
        converter.setSigningKey(SIGNING_KEY); // 对称秘钥，资源服务器使用该秘钥来验证
        return converter ;
    }
}
