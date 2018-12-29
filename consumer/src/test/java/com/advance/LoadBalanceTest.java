package com.advance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description 负载均衡算法测试
 * @Author zcc
 * @Date 18/12/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserConsumerApplication.class)
public class LoadBalanceTest {

    @Autowired
    RibbonLoadBalancerClient client;

    /**
     * @Description: 对于负载均衡的测试
     * @param:  * @param
     * @return: void
     */
    @Test
    public void loadBanlanceTest1 ( ){
        for (int i = 0; i < 100; i++) {
            ServiceInstance instance = this.client.choose("user-service");
            System.out.println(instance.getHost() + ":" + instance.getPort());
        }

    }
}
