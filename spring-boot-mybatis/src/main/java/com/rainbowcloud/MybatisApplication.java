package com.rainbowcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author DingYihang
 */
@MapperScan(basePackages ={"com.rainbowcloud.mapper"})
@SpringBootApplication
public class MybatisApplication {
    public static void main(String[] args) {
       SpringApplication.run(MybatisApplication.class, args);
    }
}
