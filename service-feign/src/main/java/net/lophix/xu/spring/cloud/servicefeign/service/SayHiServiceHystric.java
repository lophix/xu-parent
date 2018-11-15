package net.lophix.xu.spring.cloud.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * create by xuj on 2018/11/8 11:00
 */
@Component
public class SayHiServiceHystric implements SayHiService {
    @Override
    public String sayHi(String name) {
        return "Hi, " + name + ", ERROR!";
    }
}
