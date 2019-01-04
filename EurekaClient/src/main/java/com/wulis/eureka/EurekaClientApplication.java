package com.wulis.eureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableEurekaClient
@SpringBootApplication
@Controller
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @ResponseBody
    @RequestMapping(value = "eureka/client")
    public String eurekaClient() {
        System.out.println("请求eurekaClient");
        return "I am EurekaClient from port:" + port;
    }
}

