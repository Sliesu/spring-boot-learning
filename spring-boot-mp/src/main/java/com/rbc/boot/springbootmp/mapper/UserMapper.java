package com.rbc.boot.springbootmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rbc.boot.springbootmp.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.security.SecurityProperties;


/**
 * @author DingYihang
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

}
