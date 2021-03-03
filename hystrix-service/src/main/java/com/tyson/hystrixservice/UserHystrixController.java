package com.tyson.hystrixservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: Tyson
 * @time: 2021-01-24 21:49
 */
public class UserHystrixController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HystrixService hystrixService;

    @GetMapping("/testFallback/{id}")
    public String testFallback(@PathVariable Long id) {
        return hystrixService.getHello();
    }
}