package net.lophix.xu.spring.cloud.servicefeign.controller;

import net.lophix.xu.spring.cloud.servicefeign.service.SayHiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * create by xuj on 2018/11/8 10:39
 */
@RestController
public class FeignSayHiController {
    @Resource
    private SayHiService sayHiService;

    @GetMapping("/{name}")
    public Mono<String> hi(@PathVariable("name") String name) {
        return Mono.create(mo -> mo.success(
                Optional.ofNullable(sayHiService.sayHi(name))
                .orElse("ERROR!")
        ));
    }
}
