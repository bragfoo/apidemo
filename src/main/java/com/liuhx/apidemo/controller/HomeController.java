package com.liuhx.apidemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HomeController {

    @Value("${spring.application.name:sample-api-default}")
    private String name;

    @GetMapping("/")
    public String index() {
        return "I'm OK!! My name is " + name;
    }

    @GetMapping("ping")
    public String ping() {
        log.info("ping请求，用于验证服务是否可用。");
        return "PONG";
    }

    @GetMapping("hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }
}
