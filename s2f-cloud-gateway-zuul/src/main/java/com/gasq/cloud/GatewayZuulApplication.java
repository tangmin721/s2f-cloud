package com.gasq.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author tangmin
 * @version V1.0
 * @Title: GatewayZuulApplication.java
 * @Package com.gasq.cloud
 * @Description: 网关
 * @date 2017-04-13 12:44:29
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulApplication.class, args);
    }
}
