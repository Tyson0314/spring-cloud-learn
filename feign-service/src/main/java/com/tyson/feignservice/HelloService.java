package com.tyson.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="hello-service", fallback = HelloFallbackService.class)
public interface HelloService {

    @GetMapping(value = "/hello")
    String getHello();
}
