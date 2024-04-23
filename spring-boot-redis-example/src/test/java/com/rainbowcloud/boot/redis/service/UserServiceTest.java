package com.rainbowcloud.boot.redis.service;

import com.rainbowcloud.boot.redis.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.SerializationUtils;
import org.springframework.test.context.ActiveProfiles;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void testSetValueAndGetValue() {
        // Given
        String key = "hello";
        String value = "world";

        // When
        userService.setValue(key, value);
        String retrievedValue = userService.getValue(key);

        // Then
        assertEquals(value, retrievedValue);
    }


    @Test
    void testSelectAll() {
        // Given
        // You might want to populate some data into the database here

        // When
        List<User> userList = userService.selectAll();

        // Then
        assertNotNull(userList);
        // Add more assertions as needed to verify the correctness of selectAll() method
    }

    @Test
    void testGetById() {
        // Given
        // You might want to insert a user into the database here

        // When
        User user = userService.getById(123); // Provide a valid userId here

        // Then
        assertNotNull(user);
        // Add more assertions as needed to verify the correctness of getById() method
    }

    @Test
    void printSystemProperties() {
        Charset charset = Charset.defaultCharset();
        System.out.println("Default Charset: " + charset.displayName());

        Map<String, Charset> charsets = Charset.availableCharsets();
        System.out.println("Available Charsets:");
        for (String name : charsets.keySet()) {
            System.out.println(name);
        }
    }

    /**
     * 获取redis中的值
     */
//    @Test
//    void testDeserializeRedisData() {
///*        // 从Redis中获取序列化的数据
//        User user = (User) redisTemplate.opsForValue().get("User::1");
//
//        // 打印用户信息
//        if (user != null) {
//            System.out.println(user.toString());
//        }*/
//
//        String msg = (String) redisTemplate.opsForValue().get("123");
//        System.out.println(msg);
//    }

    @Test
    void testDeserializeRedisData() {
        // 从Redis中获取存储的字符串
        String msg = (String) redisTemplate.opsForValue().get("123");

        // 打印字符串
        System.out.println(msg);
    }

}
