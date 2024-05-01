package com.rbc.boot.filter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author DingYihang
 */
@Slf4j
@Component
public class Customlnterceptor implements HandlerInterceptor {
    /**
     * @param request 请求
     * @param response 响应
     * @param handler 处理器
     * @return 是否继续执行
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle,请求接口前执行");
        // 返回true才会继续向下执行，返回false取消当前请求
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
