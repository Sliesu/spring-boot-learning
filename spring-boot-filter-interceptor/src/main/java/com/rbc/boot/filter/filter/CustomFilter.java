package com.rbc.boot.filter.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter("/*")
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        log.info("CustomFilter 创建");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
//        log.info("CustomFilter 处理过滤前的请求");

        chain.doFilter(request, response);

//        log.info("CustomFilter 处理过滤后的响应");
    }

    @Override
    public void destroy() {
        log.info("CustomFilter 销毁");
    }
}
