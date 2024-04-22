package com.rainbowcloud.boot.redis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.rainbowcloud.boot.redis.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author DingYihang
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
