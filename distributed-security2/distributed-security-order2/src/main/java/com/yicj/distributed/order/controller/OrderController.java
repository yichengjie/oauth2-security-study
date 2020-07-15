package com.yicj.distributed.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OrderController
 * Description: TODO(描述)
 * Date: 2020/7/15 6:31
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@RestController
@RequestMapping("/r")
public class OrderController {

    @GetMapping("/r1")
    //@PreAuthorize("hasAnyAuthority('p1')")
    public String r1(){
        return "访问资源1";
    }
}
