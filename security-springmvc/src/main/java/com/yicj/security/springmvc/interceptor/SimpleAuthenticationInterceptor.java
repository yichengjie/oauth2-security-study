package com.yicj.security.springmvc.interceptor;

import com.yicj.security.springmvc.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * //1. 校验用户是否登录
 * //2. 校验用户是否拥有操作权限
 * ClassName: SimpleAuthenticationInterceptor
 * Description: TODO(描述)
 * Date: 2020/7/13 21:57
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 读取会话信息
        Object object = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if (object == null){
            writeContent(response, "请登录") ;
            return false ;
        }

        UserDto user = (UserDto) object ;
        // 请求url
        String requestURI = request.getRequestURI();
        if (user.getAuthorities().contains("p1") && requestURI.contains("/r1")){
            return true ;
        }
        if (user.getAuthorities().contains("p2") && requestURI.contains("/r2")){
            return true ;
        }
        writeContent(response, "权限不足，拒绝访问");
        return false;
    }

    // 响应输出
    private void writeContent(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(msg);
        writer.close();
        response.resetBuffer();
    }
}
