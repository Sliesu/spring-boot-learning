package com.rainbowcloud.boot.cache;

import com.rainbowcloud.boot.cache.entity.Address;
import com.rainbowcloud.boot.cache.entity.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: ytq
 * @create: 2024-04-22 13:53
 **/
@SpringBootTest
public class RedisTemplateTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, User> redisTemplate;

    @Test
    void stringRedisTemplateTest() {
        stringRedisTemplate.opsForValue().set("hello1", "world", 60, TimeUnit.SECONDS);
    }
    @Test
    public void redisTemplateTest() {
        Address address = Address.builder().province("江苏").city("南京").build();
        User user = User.builder().id("111").name("张三").address(address).build();
        redisTemplate.opsForValue().set("user", user, 120, TimeUnit.SECONDS);
    }
}
