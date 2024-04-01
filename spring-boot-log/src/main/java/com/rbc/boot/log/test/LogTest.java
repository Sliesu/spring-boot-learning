package com.rbc.boot.log.test;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author DingYihang
 */
@Slf4j
public class LogTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args){
//        LOGGER.trace("Trace 日志...");
//        LOGGER.debug("debug 日志...");
//        LOGGER.info("info 日志...");
//        LOGGER.warn("warn 日志...");
//        LOGGER.error("error 日志...");
        Logger myLogger = LoggerFactory.getLogger("MyLogger");
        myLogger.info("MyLogger info 日志...");
    }
}
