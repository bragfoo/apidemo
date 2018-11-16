package com.liuhx.apidemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExTestController {

    @GetMapping("ex")
    public String ex() {
        throw new RuntimeException("测试返回异常");
    }

    @GetMapping("bind")
    public String bindEx() {
        throw new IllegalArgumentException("测试异常");
    }

}
