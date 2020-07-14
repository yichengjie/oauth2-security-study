package com.yicj.distributed.uua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * ClassName: UAAServer
 * Description: TODO(描述)
 * Date: 2020/7/14 21:01
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class UAAServer {

    public static void main(String[] args) {
        SpringApplication.run(UAAServer.class, args) ;
    }
}
