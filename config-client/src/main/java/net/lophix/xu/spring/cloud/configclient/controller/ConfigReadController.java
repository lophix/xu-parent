package net.lophix.xu.spring.cloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * create by xuj on 2018/11/8 15:39
 */
@RestController
@RefreshScope
public class ConfigReadController {

    @Value("${foo}")
    private String foo;
    @Value("${hello.world}")
    private String helloWorld;

    @RequestMapping("/hi")
    public Mono<String> hi() {
        return Mono.just(helloWorld + " this is " + foo);
    }

}
