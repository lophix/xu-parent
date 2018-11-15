package net.lophix.xu.spring.cloud.serviceribbon.controller;

import net.lophix.xu.spring.cloud.serviceribbon.service.HiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * create by xuj on 2018/11/7 21:22
 */
@RestController
public class SayHiController {
    @Resource
    private HiService hiService;

    @GetMapping("/{name}")
    public Mono<String> hi(@PathVariable("name") String name) {
        return hiService.hi(name);
    }
}
