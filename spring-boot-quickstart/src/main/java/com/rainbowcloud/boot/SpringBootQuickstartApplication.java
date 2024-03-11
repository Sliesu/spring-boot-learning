package com.rainbowcloud.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


@SpringBootApplication
@Slf4j
public class SpringBootQuickstartApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringBootQuickstartApplication.class);
		Environment env = app.run(args).getEnvironment();
		log.info("启动成功");
		log.info("swagger文档地址：http://localhost:{}/swagger-ui/index.html#/", env.getProperty("server.port"));
		log.info("knife4j文档地址：http://localhost:{}/doc.html#/home", env.getProperty("server.port"));
	}
}
