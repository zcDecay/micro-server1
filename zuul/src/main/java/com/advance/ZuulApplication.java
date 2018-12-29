package com.advance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description zuul网关
 *      EnableZuulProxy ： 开启Zuul网关功能
 *      EnableDiscoveryClient ：开启Eureka客户端
 * @Author zcc
 * @Date 18/12/26
 */
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class);
    }
}
