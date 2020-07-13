package com.yicj.security.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ClassName: UserDto
 * Description: TODO(描述)
 * Date: 2020/7/13 21:23
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@Data
@AllArgsConstructor
public class UserDto {
    public static final String SESSION_USER_KEY = "_user";

    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
