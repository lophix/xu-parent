package net.lophix.xu.spring.cloud.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * create by xuj on 2018/11/8 11:30
 */
@Component
public class MyFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

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
        var ctx = RequestContext.getCurrentContext();
        var request = ctx.getRequest();
        logger.info("{} >>> {}", request.getMethod(), request.getRequestURL().toString());
        var accessToken = request.getParameter("token");
        if (accessToken == null) {
            logger.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
                logger.error("exception message={}", e.getMessage());
            }
            return null;
        }
        logger.info("ok");
        return null;
    }
}
