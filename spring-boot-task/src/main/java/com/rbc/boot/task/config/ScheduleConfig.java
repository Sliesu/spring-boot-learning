package com.rbc.boot.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 定时任务配置类，实现 SchedulingConfigurer 接口以自定义任务执行器。
 * 这里配置了一个线程池来执行定时任务。
 * 通过 {@link #configureTasks(ScheduledTaskRegistrar)} 方法配置定时任务。
 * 通过 {@link #taskExecutor()} 方法配置任务执行器。
 * @author DingYihang
 */
@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {

    /**
     * 配置定时任务。
     *
     * @param taskRegistrar 用于配置定时任务的任务注册器
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        // 配置定时任务
        taskRegistrar.setScheduler(taskExecutor());
    }

    /**
     * 配置任务执行器。
     *
     * @return 任务执行器
     */
    @Bean
    public Executor taskExecutor() {
        // 创建一个拥有10个线程的定时任务线程池
        return Executors.newScheduledThreadPool(10);
    }
}
