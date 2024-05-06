package com.rbc.boot.task.task;

import lombok.extern.slf4j.Slf4j;
import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

/**
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author DingYihang
 */

@Slf4j
@Component
public abstract class AbstractTask {

    public void doTaskOne() throws InterruptedException {
        log.info("开始做任务一!");
        long startTime = System.currentTimeMillis();
        Thread.sleep(3080);
        long endTime = System.currentTimeMillis();
        log.info("完成任务一，耗时: {} 毫秒", endTime - startTime);
    }

    public void doTaskTwo() throws InterruptedException {
        log.info("开始做任务二!");
        long startTime = System.currentTimeMillis();
        Thread.sleep(4080);
        long endTime = System.currentTimeMillis();
        log.info("完成任务二，耗时: {} 毫秒", endTime - startTime);
    }

    public void doTaskThree() throws InterruptedException {
        log.info("开始做任务三!");
        long startTime = System.currentTimeMillis();
        Thread.sleep(5080);
        long endTime = System.currentTimeMillis();
        log.info("完成任务三，耗时: {} 毫秒", endTime - startTime);
    }
}

