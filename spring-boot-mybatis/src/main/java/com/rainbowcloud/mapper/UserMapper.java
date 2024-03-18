package com.rainbowcloud.mapper;

import com.rainbowcloud.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author DingYihang
 */
@Mapper
public interface UserMapper {

        int deleteByPrimaryKey(Integer id);

        int insert(User record);

        int insertSelective(User record);

        User selectByPrimaryKey(Integer id);

        int updateByPrimaryKeySelective(User record);

        int updateByPrimaryKey(User record);

        @Select("SELECT * FROM user ")
        List<User> selectAll();
}
