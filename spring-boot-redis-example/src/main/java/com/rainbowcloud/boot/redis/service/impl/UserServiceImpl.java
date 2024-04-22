package com.rainbowcloud.boot.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowcloud.boot.redis.entity.User;
import com.rainbowcloud.boot.redis.mapper.UserMapper;
import com.rainbowcloud.boot.redis.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.io.Serializable;
import java.util.List;

/**
 * @author DingYihang
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String getValue(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    @Override
    @Cacheable(value = "Users", key = "'selectAll'")
    public List<User> selectAll() {
        return userMapper.selectList(Wrappers.<User>query().orderByAsc("create_time"));
    }

    @Override
    @CachePut(value = "User", key = "#id")
    public User getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    @CachePut(value = "User", key = "#entity.id")
    public void updateData(User entity) {
        super.updateById(entity);
    }


    @Override
    @CacheEvict(value = "User", key = "#id")
    public void deleteById(Serializable id) {
        super.removeById(id);
    }

}
