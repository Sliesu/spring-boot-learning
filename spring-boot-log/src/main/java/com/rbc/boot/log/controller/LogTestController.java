package com.rbc.boot.log.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author DingYihang
 */
@RestController
public class LogTestController {

    private static final Logger logger = LoggerFactory.getLogger(LogTestController.class);
    @GetMapping("/logTest")
    public void test() {
        logger.trace("Trace 日志...");
        logger.debug("Debug 日志...");
        logger.info("Info 日志...");
        logger.warn("Warn 日志...");
        logger.error("Error 日志...");
    }
}