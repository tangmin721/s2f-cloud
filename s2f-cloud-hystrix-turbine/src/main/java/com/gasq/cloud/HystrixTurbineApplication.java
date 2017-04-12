package com.gasq.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author tangmin
 * @version V1.0
 * @Title: HystrixTurbineApplication.java
 * @Package com.gasq.cloud
 * @Description: 集群版监控
 * @date 2017-04-12 23:49:22
 */
@SpringBootApplication
@EnableTurbine
public class HystrixTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class, args);
    }
}
