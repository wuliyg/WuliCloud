package com.wulis.zuul.common.zuulFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Herman on 2019/1/3.
 */

@Component
public class ZuFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ZuFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("访问路径:" + request.getServletPath());
        if (request.getServletPath().equals("/Ribbon/ribbon")) {
            try {
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                ctx.getResponse().getWriter().write("To ribbon by zuul not allowed!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
        }
        return null;
    }
}