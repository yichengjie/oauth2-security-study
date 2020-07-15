package com.yicj.distributed.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: OrderServer
 * Description: TODO(描述)
 * Date: 2020/7/14 21:35
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderServer4 {

    public static void main(String[] args) {
        SpringApplication.run(OrderServer4.class, args) ;
    }
}
