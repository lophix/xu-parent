package net.lophix.xu.spring.cloud.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * create by xuj on 2018/11/7 19:38
 */
@RestController
public class SayHiController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/sayHi")
    public Mono<String> sayHi(@RequestParam("name") String name) {
        return Mono.just("Hi, " + name + ", this is " + port);
    }
}
