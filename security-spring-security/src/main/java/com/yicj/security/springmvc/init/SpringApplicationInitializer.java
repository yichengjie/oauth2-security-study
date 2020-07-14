package com.yicj.security.springmvc.init;

import com.yicj.security.springmvc.config.ApplicationConfig;
import com.yicj.security.springmvc.config.WebConfig;
import com.yicj.security.springmvc.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * SpringApplicationInitializer相当于web.xml，使用了servlet3.0开发不需要web.xml
 * ClassName: SpringApplicationInitializer
 * Description: TODO(描述)
 * Date: 2020/7/13 20:38
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //ApplicationConfig.class对应以下配置的application-context.xml
    // 指定rootContext的配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // 注意这里需要将WebSecurityConfig添加到rootConfigClasses中而不是servletConfigClasses中
        return new Class[] {ApplicationConfig.class, WebSecurityConfig.class};
    }

    //WebConfig.class对应以下配置的springmvc.xml
    // 指定servletContext的配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }


    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
