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

    @RequestMapping("getZipkinB")
    public String getZipkinB() {
        String result = zipkinBService.getFoo();
        return result;
    }

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "getFoo")
    public String getFoo() {
        return foo;
    }

}
