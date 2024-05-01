package com.rbc.boot.filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class FilterInterceptorApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilterInterceptorApplication.class, args);
    }
}
