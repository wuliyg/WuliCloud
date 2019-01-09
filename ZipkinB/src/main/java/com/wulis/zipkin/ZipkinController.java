package com.wulis.zipkin;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Herman on 2019/1/4.
 */
@RestController
public class ZipkinController {

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "getFoo")
    public String getFoo() {
        return foo;
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "getZipkinA")
    @HystrixCommand(fallbackMethod = "getZipkinAError")
    public String ribbon() {
        return restTemplate.getForObject("http://ZipkinA/getFoo", String.class);
    }

    public String getZipkinAError() {
        return "ZipkinA Error";
    }
}
