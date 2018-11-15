package net.lophix.xu.spring.cloud.serviceribbon.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * create by xuj on 2018/11/7 21:06
 */
@Service
public class HiService {
    @Resource
    private RestTemplate restTemplate;

    public Mono<String> hi(String name) {
        return Mono.create(mo -> mo.success(Optional
                .ofNullable(restTemplate.getForObject("http://SAY-HI/sayHi?name=" + name, String.class))
                .orElse("ERROR!")));
    }
}
