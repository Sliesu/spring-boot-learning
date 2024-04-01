package com.rbc.boot.springbootmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbc.boot.springbootmp.entity.UserDO;
import com.rbc.boot.springbootmp.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void insert() {
        UserDO userDO = new UserDO().setUsername("宇涛").setPhone("1234567890").setGander("男");
        int rs = userMapper.insert(userDO);
        System.out.println(userDO.getId());

    }


    @Test
    void delete() {
        // 根据id删除
        // userMapper.deleteById(5);
        // 根据条件删除
        userMapper.delete(new LambdaQueryWrapper<UserDO>()
                .eq(UserDO::getUsername, "伟康"));
    }

    @Test
    void update() {
        // 1. 根据id更新
        userMapper.updateById(new UserDO()
                .setId(1)
                .setPhone("1234567890"));

        // 2. 根据条件更新
        userMapper.update(new UserDO().setUsername("伟康"), new LambdaQueryWrapper<UserDO>()
                        .eq(UserDO::getPhone, "1234567890"));
        //3.不创建项目
        userMapper.update(
                null,
                new LambdaUpdateWrapper<UserDO>()
                        .set(UserDO::getCreateTime, LocalDateTime.now())
                        .set(UserDO::getDeleted, 1)
                        .eq(UserDO::getUsername, "宇涛")
        );


    }

    @Test
    void select() {
        // 查询所有
        List<UserDO> userDOs = userMapper.selectList(null);
        System.out.println("********************");
        System.out.println(userDOs);
    }

    /**
     * 查询性别并分组
     */
    @Test
    public void groupBy() {
        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        wrapper.select("gender, count(*) as total").groupBy("gender");
        // 注意要用listMaps,返回的是List<Map<String, Object>>
        List<Map<String, Object>> mapList = userMapper.selectMaps(wrapper);
        System.out.println(mapList);
    }

    /**
     * 查询最大id
     */
    @Test
    public void testSelectMaxId() {
        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        wrapper.select("max(id) as id");
        UserDO user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    /**
     * 查询分页
     *
     * SELECT id,username,phone,gender AS gander,create_time,update_time,deleted
     * FROM user WHERE deleted=0
     */
    @Test
    void selectPage(){
        Page<UserDO> page = new Page<>(2, 2);
        IPage<UserDO> userIPage = userMapper.selectPage(page, null);
        System.out.println(userIPage);

    }


}