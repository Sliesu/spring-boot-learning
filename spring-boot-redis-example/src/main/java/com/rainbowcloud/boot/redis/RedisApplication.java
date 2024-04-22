package com.rainbowcloud.boot.redis;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;

@Slf4j
@EnableCaching
@SpringBootApplication
@MapperScan(basePackages = {"com.rainbowcloud.boot.redis.mapper"})

public class RedisApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RedisApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("启动成功");
        log.info("swagger文档地址：http://localhost:{}/swagger-ui/index.html#/", env.getProperty("server.port"));
        log.info("knife4j文档地址：http://localhost:{}/doc.html#/home", env.getProperty("server.port"));
    }

}
