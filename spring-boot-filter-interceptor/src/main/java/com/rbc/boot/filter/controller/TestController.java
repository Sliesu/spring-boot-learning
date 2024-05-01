package com.rbc.boot.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @GetMapping("/logging")
    public String loggingTest() {

        return "logging test Done!";
    }
}
