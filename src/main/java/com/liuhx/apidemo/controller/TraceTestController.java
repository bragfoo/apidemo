package com.liuhx.apidemo.controller;


import com.liuhx.apidemo.config.properties.ThirdTestServiceProperties;
import com.liuhx.apidemo.service.TraceTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 测试调用链路日志记录
 *
 * @author shiyongbiao
 */
@Slf4j
@RestController
@RequestMapping("trace")
public class TraceTestController {

    @Resource
    TraceTestService traceTestService;
    @Resource
    RestTemplate restTemplate;
    @Resource
    ThirdTestServiceProperties properties;

    @GetMapping("log")
    public String log() throws InterruptedException {
        log.info("测试trace日志-controller-1");
        traceTestService.log();
        log.info("测试trace日志-controller-2");
        traceTestService.asyncLog();
        log.info("测试trace日志-controller-3");
        String r = restTemplate.getForObject(properties.getRootUri() + properties.getPingUri(), String.class);
        log.info("请求返回结果：{}", r);
        return "success";
    }
}
