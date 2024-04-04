package com.rbc.boot.log.config;

import com.rbc.boot.log.interceptor.AccessLogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author DingYihang
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    //设置排除路径，注意排除掉静态资源的路径，不然静态资源无法访问
    private final String[] excludePath = {"/static"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessLogInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePath);
    }
}