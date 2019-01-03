package com.wulis.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dell on 2019/1/2.
 */
@FeignClient(value = "EurekaClient", fallback = EurekaClientImpl.class)
public interface EurekaClient {
    @RequestMapping(value = "eureka/client")
    String eurekaClient();
}
