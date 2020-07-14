package com.yicj.security.springmvc.model;

import lombok.Data;

/**
 * ClassName: AuthenticationRequest
 * Description: TODO(描述)
 * Date: 2020/7/13 21:23
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Data
public class AuthenticationRequest {
    private String username;

    private String password;
}
