package com.liuhx.apidemo.service.impl;

import com.liuhx.apidemo.service.TraceTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TraceTestServiceImpl implements TraceTestService {

    @Override
    public void log() throws InterruptedException {
        log.info("测试服务服务日志-1");
        Thread.sleep(1000);
        log.info("测试服务服务日志-2");
    }

    @Async
    @Override
    public void asyncLog() throws InterruptedException {
        log.info("测试服务日志－－异步调用-1");
        Thread.sleep(2000);
        log.info("测试服务日志－－异步调用-2");
    }


}
