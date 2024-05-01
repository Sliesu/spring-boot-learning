package com.rbc.boot.filter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 认证拦截器
 * @author DingYihang
 */
@Slf4j
@Component
public class Authenticationlnterceptor implements HandlerInterceptor{
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
        String token = request.getHeader("Authentication");
        if(token != null){
            // 验证token是否有效
            log.info("token验证通过");
            return true;
        }else{
            log.info("token验证失败");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }
}
