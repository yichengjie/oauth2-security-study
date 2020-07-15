package com.yicj.distributed.gateway.component;

import com.yicj.distributed.gateway.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

/**
 * ClassName: GatewayWebSecurityExpressionHandler
 * Description: TODO(描述)
 * Date: 2020/7/15 15:25
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Component
public class GatewayWebSecurityExpressionHandler extends OAuth2WebSecurityExpressionHandler {

    @Autowired
    private PermissionService permissionService ;

    @Override
    protected StandardEvaluationContext createEvaluationContextInternal(
            Authentication authentication, FilterInvocation invocation) {
        StandardEvaluationContext sec = super.createEvaluationContextInternal(authentication, invocation);
        // 添加permissionService字符串的处理
        sec.setVariable("permissionService", permissionService);
        return sec ;
    }
}
