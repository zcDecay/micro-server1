package com.advance.controller;

import com.advance.entity.User;
import com.advance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description consumer
 * @Author zcc
 * @Date 18/12/19
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private UserService userService;

    @GetMapping("/{ids}")
    public List<User> consume(@PathVariable("ids") List<Long> ids) {
        return this.userService.queryUserByIdList(ids);
    }
}
