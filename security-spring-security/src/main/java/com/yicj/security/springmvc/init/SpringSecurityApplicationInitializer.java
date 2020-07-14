package com.yicj.security.springmvc.init;

import com.yicj.security.springmvc.config.WebSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * ClassName: SpringSecurityApplicationInitializer
 * Description: TODO(描述)
 * Date: 2020/7/14 10:19
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public class SpringSecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    // 如果当前环境是spring，我们可以在现有的springContext中注册Spring Security
    // 因为已经在SpringApplicationInitializer中将WebSecurityConfig添加到rootContext，所以此处可以什么都不做
    public SpringSecurityApplicationInitializer(){
        //super(WebSecurityConfig.class);
    }

}
