package com.yicj.distributed.uua.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

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

    @Bean
    public TokenStore tokenStore(){

        return new InMemoryTokenStore() ;
    }
}
