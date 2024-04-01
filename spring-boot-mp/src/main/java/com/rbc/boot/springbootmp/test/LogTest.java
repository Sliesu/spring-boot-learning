package com.rbc.boot.springbootmp.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author yun
 * @Date: 2024/04/01/ 15:37
 * @description
 */
public class LogTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args){
        LOGGER.trace("Trace 日志...");
        LOGGER.debug("debug 日志...");
        LOGGER.info("info 日志...");
        LOGGER.warn("warn 日志...");
        LOGGER.error("error 日志...");
    }
}
