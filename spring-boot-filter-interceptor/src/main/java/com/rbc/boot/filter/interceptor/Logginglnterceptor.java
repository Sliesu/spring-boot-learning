package com.rbc.boot.filter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Enumeration;

/**
 * 编写Logginglnterceptor拦截器，实现对任何接口请求，输入日志信息，包括请求方法、请求的目标资源、请求参数、发起请求时间等
 * @author DingYihang
 */
@Slf4j
@Component
public class Logginglnterceptor implements HandlerInterceptor {
    /**
     * @param request 请求
     * @param response 响应
     * @param handler 处理器
     * @return 是否继续执行
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //开始响应时间

        Instant startTime = Instant.now();
        request.setAttribute("startTime", startTime);

        log.info("用户的请求资源:{}", request.getRequestURI());
        log.info("请求的方法: {}", request.getMethod());
        log.info("请求的参数<key,value>:");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            log.info("<{} : {}>", key, request.getParameter(key));
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        Instant startTime = (Instant) request.getAttribute("startTime");
        // 结束响应时间
        Instant endTime = Instant.now();
        long duration = Duration.between(startTime, endTime).toMillis();
        log.info("处理响应时长: {} ms", duration);
    }

}
