package com.rbc.boot.filter.config;

import com.rbc.boot.filter.interceptor.Authenticationlnterceptor;
import com.rbc.boot.filter.interceptor.Customlnterceptor;
import com.rbc.boot.filter.interceptor.Logginglnterceptor;
import com.rbc.boot.filter.interceptor.PerformanceInterceptor;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author DingYihang
 */
@Configuration
@AllArgsConstructor
public class SpringMvcConfig implements WebMvcConfigurer {
    //全参构造
   private final Customlnterceptor customlnterceptor;
   private final Authenticationlnterceptor authenticationlnterceptor;
   private final Logginglnterceptor logginglnterceptor;
   private final PerformanceInterceptor performanceInterceptor;

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration
                ();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }

/*    *//**
     * @param registry
     *//*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customlnterceptor);
    }
    */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(logginglnterceptor);
        registry.addInterceptor(performanceInterceptor);
    }

}