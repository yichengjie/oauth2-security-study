package com.yicj.distributed.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ClassName: com.yicj.distributed.discovery.DiscoveryServer
 * Description: TODO(描述)
 * Date: 2020/7/15 10:09
 *
 * @author yicj(626659321 @ qq.com)
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息
 */
@EnableEurekaServer
@SpringBootApplication
public class DiscoveryServer4 {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServer4.class, args) ;
    }
}
