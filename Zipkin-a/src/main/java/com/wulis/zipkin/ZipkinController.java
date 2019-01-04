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
    ZipkinBService zipkinBService;

    @RequestMapping("toZipkin-b")
    public String toZipkinB() {
        System.out.println("请求zipkin-a");
        String result = zipkinBService.zipkinBService();
        return result;
    }

    @Value("${config}")
    String config;

    @RequestMapping(value = "getConfig")
    public String getConfig() {
        return config;
    }
}
