package com.rbc.boot.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * @author DingYihang
 */
@SpringBootApplication
public class LogApplication {
    public static void main(String[] args) {
        // 调用日志记录方法
        SpringApplication.run(LogApplication.class, args);
    }
}

