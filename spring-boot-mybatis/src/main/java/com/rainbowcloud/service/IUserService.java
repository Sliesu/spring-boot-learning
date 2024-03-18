package com.rainbowcloud.service;

import com.rainbowcloud.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DingYihang
 */

public interface IUserService {


    public List<User> selectAll();
}
