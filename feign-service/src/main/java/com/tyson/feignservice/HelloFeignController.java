package com.tyson.feignservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Tyson
 * @time: 2021-01-24 23:33
 */
@RestController
public class HelloFeignController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String getHello() {
        return helloService.getHello();
    }
}