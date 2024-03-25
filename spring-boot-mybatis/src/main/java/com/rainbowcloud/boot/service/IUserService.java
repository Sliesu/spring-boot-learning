package com.rainbowcloud.boot.service;

import com.rainbowcloud.boot.entity.User;

import java.util.List;

/**
 * @author DingYihang
 */

public interface IUserService {


    public List<User> selectAll();
}
