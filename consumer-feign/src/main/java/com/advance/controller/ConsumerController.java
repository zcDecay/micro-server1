package com.advance.controller;

import com.advance.entity.User;
import com.advance.feignclient.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description consumer
 * @Author zcc
 * @Date 18/12/19
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/{id}")
    public User consume(@PathVariable("id") Long id) {
        long begin = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        // 记录访问用时：
        User user = userFeignClient.queryUserById(id);
        logger.info("访问用时：{}", end - begin);
        return user;
    }
}
