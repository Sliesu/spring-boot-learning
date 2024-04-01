package com.rainbowcloud.boot.database;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author DingYihang
 */
@MapperScan(basePackages = "com.rainbowcloud.database.mapper")
@SpringBootApplication
public class DatabaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }
}
