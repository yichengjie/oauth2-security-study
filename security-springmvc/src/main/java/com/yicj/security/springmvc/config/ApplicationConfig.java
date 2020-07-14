package com.yicj.security.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 对应web.xml中ContextLoaderListener的配置
 * ClassName: ApplicationConfig
 * Description: TODO(描述)
 * Date: 2020/7/13 20:24
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Configuration
@ComponentScan(
    basePackages = "com.yicj.security.springmvc",
    excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)}
)
public class ApplicationConfig {
    // 在此类中配置除了Controller的其他bean，比如数据库连接池，事务管理器，业务bean等。
}
