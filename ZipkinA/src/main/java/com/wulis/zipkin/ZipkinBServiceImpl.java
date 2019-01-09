package com.wulis.zipkin;

import org.springframework.stereotype.Component;

/**
 * Created by dell on 2019/1/2.
 */
@Component
public class ZipkinBServiceImpl implements ZipkinBService {
    @Override
    public String getFoo() {
        return "ZipkinBService Error!";
    }
}
