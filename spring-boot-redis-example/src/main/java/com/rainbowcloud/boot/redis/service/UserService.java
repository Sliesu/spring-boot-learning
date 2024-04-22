package com.rainbowcloud.boot.redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbowcloud.boot.redis.entity.User;

import java.io.Serializable;
import java.util.List;


/**
 * @author DingYihang
 */
public interface UserService extends IService<User> {
    void setValue(String key, String value);
    String getValue(String key);
    List<User> selectAll();
    @Override
    User getById(Serializable id);
    void deleteById(Serializable id);
    void updateData(User entity);
}
