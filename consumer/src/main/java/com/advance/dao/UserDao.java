package com.advance.dao;

import com.advance.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Description 添加熔断处理
 * @Author zcc
 * @Date 18/12/24
 */
@Component
public class UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @Description: 添加服务熔断（超时等默认是1000毫秒进行回滚处理），声明失败回滚处理函数
     * @param:  * @param id
     * @return: com.advance.entity.User
     */
    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    public User queryUserById(Long id){
        long begin = System.currentTimeMillis();
        String baseUrl = "http://user-service/user/" + id;
        User user = this.restTemplate.getForObject(baseUrl, User.class);
        long end = System.currentTimeMillis();
        // 记录访问用时：
        logger.info("访问用时：{}", end - begin);
        return user;
    }

    /**
     * @Description: 熔断器返回失败函数,参数必须和原参数一致
     * @param:  * @param id
     * @return: com.advance.entity.User
     */
    public User queryUserByIdFallback(Long id){
        logger.info("访问消费者  ====> feign Hystrix失败熔断 ====> 9001 {}", id);
        User user = new User();
        user.setId(id.intValue());
        user.setPickName("用户信息查询出现异常");
        return user;
    }
}
