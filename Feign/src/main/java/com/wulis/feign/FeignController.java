package com.wulis.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dell on 2019/1/2.
 */
@Controller
public class FeignController {
    @Autowired
    EurekaClient eurekaClient;

    @ResponseBody
    @RequestMapping("feign")
    public String feign() {
        return eurekaClient.getFoo();
    }
}
