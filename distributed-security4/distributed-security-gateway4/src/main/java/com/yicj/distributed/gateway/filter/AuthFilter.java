package com.yicj.distributed.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.yicj.distributed.gateway.common.EncryptUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: AuthFilter
 * Description: TODO(描述)
 * Date: 2020/7/15 11:36
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //1. 获取令牌内容
        RequestContext ctx = RequestContext.getCurrentContext() ;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof OAuth2Authentication)){
            // 无token访问网关资源的情况，目前仅有uua服务直接暴露
            return null ;
        }
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication ;
        Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
        List<String> authorities = new ArrayList<>();
        userAuthentication.getAuthorities().stream().forEach(s -> {
            GrantedAuthority grantedAuthority = GrantedAuthority.class.cast(s) ;
            authorities.add(grantedAuthority.getAuthority());
        });

        OAuth2Request oAuth2Request = oAuth2Authentication.getOAuth2Request();
        Map<String, String> requestParameters = oAuth2Request.getRequestParameters();
        Map<String,Object> jsonToken = new HashMap<>(requestParameters) ;
        if (userAuthentication != null){
            jsonToken.put("principal", userAuthentication.getPrincipal()) ;
            jsonToken.put("authorities", authorities) ;
        }
        ctx.addZuulRequestHeader("json-token", EncryptUtil.encodeUTF8StringBase64(JSON.toJSONString(jsonToken)));
        return null;
    }
}
