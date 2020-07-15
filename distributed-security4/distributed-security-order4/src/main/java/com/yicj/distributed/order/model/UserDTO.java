package com.yicj.distributed.order.model;

import lombok.Data;
import java.util.Set;

@Data
public class UserDTO
{
    public static final String SESSION_USER_KEY = "_user";

    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;

    // 用户权限
    private Set<String> authorities ;
}