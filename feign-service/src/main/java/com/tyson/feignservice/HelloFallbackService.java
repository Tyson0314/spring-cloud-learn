package com.tyson.feignservice;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Tyson
 * @time: 2021-01-24 23:50
 */
@Component
public class HelloFallbackService implements HelloService {
    @Override
    public String getHello() {
        return "hello fallback";
    }
}