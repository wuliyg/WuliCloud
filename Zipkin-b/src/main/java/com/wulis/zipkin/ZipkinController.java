package com.wulis.zipkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Herman on 2019/1/4.
 */
@RestController
public class ZipkinController {
    @Autowired
    EurekaClient eurekaClient;

    @RequestMapping("zipkin-b/feign/eureka")
    public String feign() {
        System.out.println("请求zipkin-b");
        String result = eurekaClient.eurekaClient();
        return result;
    }

    @Value("${config}")
    String config;

    @RequestMapping(value = "/getConfig")
    public String getConfig() {
        return config;
    }
}
