package com.rainbowcloud.boot.service.impl;

import com.rainbowcloud.boot.entity.User;
import com.rainbowcloud.boot.service.IUserService;
import com.rainbowcloud.boot.mapper.UserMapper;
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
        return null;
    }
}
