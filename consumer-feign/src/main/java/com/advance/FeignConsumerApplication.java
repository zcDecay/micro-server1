package com.advance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author newt
 *  @EnableDiscoveryClient：开启Eureka服务器
 *  @EnableAutoConfiguration： 排除数据库自动配置
 *  @EnableHystrix：开启服务熔断
 *  @EnableFeignClients: 开启Feign功能，Feign自动集成了Ribbon负载均衡，不需要自己定义RestTemplate
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
//@EnableHystrix
@EnableFeignClients
public class FeignConsumerApplication {

	/**
	 * @Description: Springboot主启动类
	 * @param:  * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		SpringApplication.run(FeignConsumerApplication.class, args);
	}
}

