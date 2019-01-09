package com.wulis.feign;

import org.springframework.stereotype.Component;

/**
 * Created by dell on 2019/1/2.
 */
@Component
public class EurekaClientImpl implements EurekaClient {
    @Override
    public String getFoo() {
        return "EurekaClient Error!";
    }
}
