package com.rbc.boot.springbootmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rbc.boot.springbootmp.entity.UserDO;
import com.rbc.boot.springbootmp.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
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

    /**
     * 插入一条数据
     *
     *INSERT INTO user ( username, phone, gender, create_time, update_time ) VALUES ( ?, ?, ?, ?, ? )
     */
    @Test
    public void insert() {
        UserDO user = new UserDO();
        user.setUsername("大大");
        user.setPhone("1234567890");
        user.setGender("女");
        Assertions.assertThat(userMapper.insert(user)).isGreaterThan(0);
        // 成功直接拿回写的 ID
        Assertions.assertThat(user.getId()).isNotNull();
    }

    /**
     * 根据条件删除(逻辑删除)
     * UPDATE user SET deleted=1 WHERE deleted=0 AND (username = ?)
     */
    @Test
    void delete() {
        // 根据id删除
        // userMapper.deleteById(5);
        // 根据条件删除
        userMapper.delete(new LambdaQueryWrapper<UserDO>()
                .eq(UserDO::getUsername, "伟康"));
    }

    /**
     * 修改
     * 1)UPDATE user SET phone=?, update_time=? WHERE id=? AND deleted=0
     * 2)UPDATE user SET username=?, update_time=? WHERE deleted=0 AND (phone = ?)
     * 3)2024-04-01T20:30:46.477761600(LocalDateTime), 李四(String)
     */
    @Test
    void update() {
        //方式一: 根据id更新
        userMapper.updateById(new UserDO().setId(1).setPhone("13800002222"));
        //方式二: 左边是需要更新的值 右边是where条件
        userMapper.update(new UserDO().setUsername("张三丰"), new LambdaQueryWrapper<UserDO>().eq(UserDO::getPhone, "13900001111"));
        //方式三：不创建User对象
        userMapper.update(null, new LambdaUpdateWrapper<UserDO>()
                .set(UserDO::getCreateTime, LocalDateTime.now()).eq(UserDO::getUsername, "李四"));


    }

    /**
     * 查询
     * 1)SELECT id,username,phone,gender,create_time,update_time,deleted FROM user WHERE id=? AND deleted=0
     * 2)SELECT id,username,phone,gender,create_time,update_time,deleted FROM user WHERE deleted=0 AND (phone = ?)
     * 3)SELECT id,username,phone,gender,create_time,update_time,deleted FROM user WHERE deleted=0 AND (username LIKE ?)
     * 4)SELECT id,username,phone,gender,create_time,update_time,deleted FROM user WHERE deleted=0
     */
    @Test
    public void select() {
        //1、根据主键获取
        UserDO userDO = userMapper.selectById(1);
        System.out.println("********** 1 *************");
        System.out.println(userDO);
        //2、根据手机号获取单个
        UserDO userDO1 = userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getPhone, "13900002222"));
        System.out.println("********** 2 *************");
        System.out.println(userDO1);
        //3、获取集合
        List<UserDO> userDOS = userMapper.selectList(new LambdaQueryWrapper<UserDO>().like(UserDO::getUsername, "小"));
        System.out.println("********** 3 *************");
        // System.out.println(userDOS);
        List<UserDO> userDOS1 = userMapper.selectList(null);
        System.out.println("********** 4 *************");
        System.out.println(userDOS1);
    }

    /**
     * 排序
     * 1)SELECT id,username,phone,gender,create_time,update_time,deleted FROM user WHERE deleted=0 ORDER BY create_time ASC
     * 2)SELECT id,username,phone,gender,create_time,update_time,deleted FROM user WHERE deleted=0 ORDER BY create_time ASC,phone ASC
     * 3)SELECT id,username,phone,gender,create_time,update_time,deleted FROM user WHERE deleted=0 ORDER BY phone ASC,create_time DESC
     * 4)SELECT id,username,phone,gender,create_time,update_time,deleted FROM user WHERE deleted=0 ORDER BY phone ASC,create_time DESC
     */
    @Test
    public void orderBy() {
        //1、单个排序
        List<UserDO> users = userMapper.selectList(Wrappers.<UserDO>query().orderByAsc("create_time"));
        //2、多字段排序
        List<UserDO> users2 = userMapper.selectList(Wrappers.<UserDO>query().orderByAsc(Lists.newArrayList("create_time", "phone")));
        //3、先按手机号升序排列，phone相同再按create_time降序排列
        List<UserDO> users3 = userMapper.selectList(Wrappers.<UserDO>query().orderByAsc("phone").orderByDesc("create_time"));
        //4、Lambda实现方式，和3实现的效果是一样的。
        List<UserDO> users4 = userMapper.selectList(new LambdaQueryWrapper<UserDO>().orderByAsc(UserDO::getPhone).orderByDesc(UserDO::getCreateTime));
    }

    /**
     * 查询性别并分组
     * SELECT gender, count(*) as total FROM user WHERE deleted=0 GROUP BY gender
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
     *
     * SELECT max(id) as id FROM user WHERE deleted = 0
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
        Page<UserDO> page = new Page<>(1, 2);
        IPage<UserDO> userIPage = userMapper.selectPage(page, null);
        System.out.println(userIPage);
    }


}