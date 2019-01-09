package com.wulis.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Herman on 2019/1/9.
 */
@RestController
public class RibbonController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "ribbon")
    @HystrixCommand(fallbackMethod = "ribbonError")
    public String ribbon() {
        return restTemplate.getForObject("http://EurekaClient/getFoo", String.class);
    }

    public String ribbonError() {
        return "EurekaClient Error";
    }
}
