package com.liuhx.apidemo.service;

public interface TraceTestService {

    void log() throws InterruptedException;

    void asyncLog() throws InterruptedException;
}
