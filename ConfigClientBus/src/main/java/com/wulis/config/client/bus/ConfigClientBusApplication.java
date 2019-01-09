package com.wulis.config.client.bus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RefreshScope
@RestController
public class ConfigClientBusApplication {

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "getFoo")
    public String getFoo() {
        return foo;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientBusApplication.class, args);
    }

}

