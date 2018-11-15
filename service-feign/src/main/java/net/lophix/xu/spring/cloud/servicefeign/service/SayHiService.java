package net.lophix.xu.spring.cloud.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * create by xuj on 2018/11/8 10:37
 */
@FeignClient(value = "SAY-HI", fallback = SayHiServiceHystric.class)
public interface SayHiService {
    @RequestMapping(value = "/sayHi", method = RequestMethod.GET)
    String sayHi(@RequestParam("name") String name);
}
