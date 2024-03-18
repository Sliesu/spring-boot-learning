package com.rainbowcloud.service.impl;

import com.rainbowcloud.entity.User;
import com.rainbowcloud.mapper.UserMapper;
import com.rainbowcloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DingYihang
 */
@Service
@Primary
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
