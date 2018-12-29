package com.advance.service;

import com.advance.entity.User;
import com.advance.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Description user
 * @Author zcc
 * @Date 18/12/19
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) throws InterruptedException {
        // 为了演示超时现象，我们在这里然线程休眠,时间随机 0~2000毫秒（测试服务熔断）
        // Thread.sleep(new Random().nextInt(2000));
        logger.info("访问服务   ====> 8080 {}", id);
        return this.userMapper.selectByPrimaryKey(id);
    }
}
