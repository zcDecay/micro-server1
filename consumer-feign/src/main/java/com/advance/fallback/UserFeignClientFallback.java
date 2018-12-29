package com.advance.fallback;

import com.advance.entity.User;
import com.advance.feignclient.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description feign的Hystrix失败回调
 * @Author zcc
 * @Date 18/12/25
 */
@Component
public class UserFeignClientFallback implements UserFeignClient{

    private static final Logger logger = LoggerFactory.getLogger(UserFeignClientFallback.class);

    @Override
    public User queryUserById(Long id) {
        logger.info("访问消费者  ====> feign Hystrix失败熔断 ====> 9001 {}", id);
        User user = new User();
        user.setId(id.intValue());
        user.setPickName("查询出现异常！");
        return user;
    }
}
