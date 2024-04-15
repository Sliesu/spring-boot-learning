package com.rbc.boot.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DingYihang
 */
@SpringBootApplication
public class ExceptionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExceptionApplication.class, args);
        System.setProperty("https.proxyHost", "localhost");
        System.setProperty("https.proxyPort", "7890");

    }
}
