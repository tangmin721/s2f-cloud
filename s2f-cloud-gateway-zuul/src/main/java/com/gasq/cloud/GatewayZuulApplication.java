package com.gasq.cloud;

import com.gasq.cloud.zuul.filter.PreRequestLogZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

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

    /**
     * 定义bean 前置zuul过滤器 PreRequestLogZuulFilter
     * @return
     */
    @Bean
    public PreRequestLogZuulFilter preRequestLogFilter() {
        return new PreRequestLogZuulFilter();
    }

    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v.+$)",
                "${version}/${name}");
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulApplication.class, args);
    }
}
