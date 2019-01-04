package com.wulis.zipkin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dell on 2019/1/2.
 */
@FeignClient(value = "Zipkin-b", fallback = ZipkinBServiceImpl.class)
public interface ZipkinBService {
    @RequestMapping(value = "zipkin-b/feign/eureka")
    String zipkinBService();
}
