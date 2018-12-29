package com.advance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * @author newt
 *  @EnableDiscoveryClient：开启Eureka服务器
 *  @EnableAutoConfiguration： 排除数据库自动配置
 *  @EnableHystrix：开启服务熔断
 */
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableHystrix
@SpringBootApplication
public class UserConsumerApplication {

	/**
	 * @Description: Springboot主启动类
	 * @param:  * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		SpringApplication.run(UserConsumerApplication.class, args);
	}

	/**
	 * @Description: 添加自定义restTemplate
	 * @LoadBalanced: 开启负载均衡：策略：轮询new RoundRobinRule();
	 * @param:  * @param
	 * @return: org.springframework.web.client.RestTemplate
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		//使用OkHttp客户端,只需要注入工厂即可
		return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
	}
}

