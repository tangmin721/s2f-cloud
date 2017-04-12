package com.gasq.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author tangmin
 * @version V1.0
 * @Title: HystrixDashboardApplication.java
 * @Package com.gasq.cloud
 * @Description: 监控单节点的hystrix.stream的图形界面
 * @date 2017-04-12 23:22:05
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}
