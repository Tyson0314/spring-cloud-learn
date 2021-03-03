package com.tyson.helloservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: Tyson
 * @time: 2020-12-29 12:40
 */
@RestController
public class HelloController {

    @Autowired
    private Registration registration;  // 服务注册

    @Autowired
    private DiscoveryClient client;

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = "/hello")
    public String hello() throws Exception {
        ServiceInstance instance = client.getInstances(registration.getServiceId()).get(0);

        // 测试超时触发断路器
//		int sleepTime = new Random().nextInt(3000);
//		logger.info("sleepTime:" + sleepTime);
//		Thread.sleep(sleepTime);

        String res = "/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId();
        LOGGER.info(res);
        return res;
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        ServiceInstance instance = client.getInstances(registration.getServiceId()).get(0);
        LOGGER.info("/hello1, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        ServiceInstance instance = client.getInstances(registration.getServiceId()).get(0);
        LOGGER.info("/hello2, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        ServiceInstance instance = client.getInstances(registration.getServiceId()).get(0);
        LOGGER.info("/hello3, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "Hello " + user.getName() + ", " + user.getAge();
    }

}