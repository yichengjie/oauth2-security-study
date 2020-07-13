package com.yicj.security.springmvc.service;

import com.yicj.security.springmvc.model.AuthenticationRequest;
import com.yicj.security.springmvc.model.UserDto;

/**
 * 认证服务
 * ClassName: AuthenticationService
 * Description: TODO(描述)
 * Date: 2020/7/13 21:22
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
public interface AuthenticationService {

    UserDto authentication(AuthenticationRequest authenticationRequest);
}
