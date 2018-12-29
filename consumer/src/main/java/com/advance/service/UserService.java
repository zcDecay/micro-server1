package com.advance.service;

import com.advance.dao.UserDao;
import com.advance.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description user
 * @Author zcc
 * @Date 18/12/19
 */
@Service
public class UserService {

    /**
     *  获取自定义RestTemplate
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Eureka客户端，可以获取到服务实例信息
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserDao userDao;

    public List<User> queryUserByIds(List<Long> ids){
        List<User> users = new ArrayList<>();
        // 未开启负载均衡
        /*// 根据发现的客户端，获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 获取服务实例
        ServiceInstance instance = instances.get(0);
        // 获取ip和端口
        String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/";*/

        // 开启负载均衡后，地址直接写服务名称即可
        String baseUrl = "http://user-service/user/";

        ids.forEach(id -> {
            users.add(this.restTemplate.getForObject(baseUrl + id, User.class));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return users;
    }

    /**
     * @Description: 通过dao的服务熔断机制调用
     * @param:  * @param ids
     * @return: java.util.List<com.advance.entity.User>
     */
    public List<User> queryUserByIdList(List<Long> ids) {
        List<User> users = new ArrayList<>();
        ids.forEach(id -> {
            // 我们测试多次查询，
            users.add(this.userDao.queryUserById(id));
        });
        return users;
    }
}
