package com.rbc.boot.log.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DingYihang
 */
@RestController
public class LogController {
    private static final Logger log = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/log")
    public void testLog() {
        log.debug("debug日志");
    }
}