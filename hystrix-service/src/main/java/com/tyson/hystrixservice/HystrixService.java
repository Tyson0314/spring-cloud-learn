package com.tyson.hystrixservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: Tyson
 * @time: 2021-01-24 22:06
 */
@Service
public class HystrixService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${service-url.hello-service}")
    private String helloService;

    @HystrixCommand(fallbackMethod = "getDefaultHello")
    public String getHello() {
        return restTemplate.getForEntity(helloService + "/hello", String.class).getBody();
    }

    public String getDefaultHello() {
        return "hello world";
    }
}