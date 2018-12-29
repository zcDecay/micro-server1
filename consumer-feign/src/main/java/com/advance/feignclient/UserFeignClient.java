package com.advance.feignclient;

import com.advance.config.FeignConfig;
import com.advance.entity.User;
import com.advance.fallback.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description: feign接口，
 *      1、Feign会通过动态代理帮我们生成接口实现类，类似于Mybatis的mapper
 *      2、@FeignClient：声明这是一个Feign客户端，类似与@Mapper注解
 *      3、接口中的定义方法，采用SpringMvc注解，Feign会帮我们自动生成URL，并获取访问结果
 * @FeignClient: Feign的服务接口
 *      1、value：服务名
 *      2、path：统一前缀
 *      3、fallback：hystrix的失败回调
 *      4、configuration：feign配置类（日志）
 * @param:  * @param null
 * @return:
 */
@FeignClient(value = "user-service", path = "/user", fallback = UserFeignClientFallback.class, configuration = FeignConfig.class)
public interface UserFeignClient {

    @GetMapping("/{id}")
    User queryUserById(@PathVariable("id") Long id);

}
