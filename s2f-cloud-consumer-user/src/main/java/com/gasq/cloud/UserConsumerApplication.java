package com.gasq.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserProviderApplication.java
 * @Package com.gasq.cloud.user.entity
 * @Description: user服务提供者，并注册到eureka
 * @date 2017-04-11 18:32:18
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserConsumerApplication {

    public static void main(String[] args) {
        /**
         * 在main方法中启动我们的应用程序
         */
        SpringApplication.run(UserConsumerApplication.class, args);
    }
}
