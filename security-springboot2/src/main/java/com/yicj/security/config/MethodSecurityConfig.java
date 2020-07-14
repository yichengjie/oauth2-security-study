package com.yicj.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * ClassName: MethodSecurityConfig
 * Description: TODO(描述)
 * Date: 2020/7/14 15:38
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class MethodSecurityConfig {
}
