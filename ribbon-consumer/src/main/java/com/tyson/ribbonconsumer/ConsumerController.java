package com.tyson.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: Tyson
 * @time: 2020-12-29 13:33
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${service-url.hello-service}")
    private String helloService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForEntity(helloService + "/hello", String.class).getBody();
    }
}