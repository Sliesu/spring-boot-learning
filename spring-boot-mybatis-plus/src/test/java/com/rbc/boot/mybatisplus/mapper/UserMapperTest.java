package com.rbc.boot.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.rbc.boot.mybatisplus.entity.User;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    @Test
    void insert() {
        User user = User.builder().name("Rose").age(19).email("rose@baomidou.com").build();
        int row = userMapper.insert(user);
        assertEquals(1, row);
        log.info("雪花算法 id: " + user.getId());
    }
    @Test
    void deleteById() {
        int rows = userMapper.deleteById(1772478797484969985L);
        System.out.println("Affected records: " + rows);
    }

    @Test
    void deleteByCondition() {
        // Construct the condition
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", 20);

        // Execute the deletion
        int rows = userMapper.deleteByMap(map);
        assertEquals(1, rows);
        System.out.println("Affected records: " + rows);
    }

    @Test
    void findById() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    void batchSearch() {
        List<Long> ids = Arrays.asList(3L, 4L, 5L);
        List<User> users = userMapper.selectBatchIds(ids);

        users.forEach(System.out::println);
    }
    @Test
    void findByParam() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jone");

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    void queryWrapper1() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.select("name", "age") // 指定查询结果字段
                .in("age", Arrays.asList(18, 19, 20))
                .last("limit 2");
        List<User> list = userMapper.selectList(query);
        list.forEach(System.out::println);
    }

    @Test
    void queryWrapper2() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.like("name", "J%") // like 是 MP 的条件构造器，表示"模糊查询"
                .lt("age", 30) // lt 是 MP 的条件构造器，表示"小于"关系
                .select("name", "age");
        List<Map<String, Object>> maps = userMapper.selectMaps(query);
        maps.forEach(System.out::println);
    }

    @Test
    void updateById() {
        User user = new User();
        user.setId(1L);
        user.setAge(28);
        user.setEmail("mybatis-plus@163.com");
        int rows = userMapper.updateById(user);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    void updateWrapper() {
        UpdateWrapper<User> update = new UpdateWrapper<>();
        update.eq("name", "Sandy").eq("age", 21); // eq 是 MP 的条件构造器，表示"等于"关系
        User user = new User();
        user.setAge(29);
        user.setEmail("Sandy@163.com");
        int rows = userMapper.update(user, update);
        System.out.println("影响记录数：" + rows);
    }


    /**
     * 测试 MP 的条件构造器 like 方法
     * <p>
     * SELECT id, name, age , email, create_time
     * FROM t_user
     * WHERE name LIKE %字母%
     */
    @Test
    void testLike() {
        String name = "Jone" ; //name不为空
        String email = "" ; //email为空串
        QueryWrapper<User> query = new QueryWrapper<>();
        query.like(StringUtils.isNotEmpty(name), "name", name);
        //因为email为空串，该条件未生效.like(StringUtils.isNotEmpty(email),"email", email);
        List<User> list = userMapper.selectList(query);
        list.forEach(System.out::println);
    }

    /**
     * 测试 MP 的条件构造器 allEq 方法
     * <p>
     * SELECT id, name , age , email, create_time
     * FROM t_user
     * WHERE age = ?
     */
    @Test
    void testAllEq() {
        //构造条件
        QueryWrapper<User> query = new QueryWrapper<>();
        Map<String, Object> params = new HashMap<>();
        params.put("name", " zhangsan ");
        params.put("age",28);
        params.put("email", null);
        query.allEq((k, v) -> !k.equals("name"), params, false);
        List<User> list = userMapper.selectList(query);
        list.forEach(System.out::println);
    }

    /**
     * lambda条件构造器
     * <p>
     * SELECT id, name , age , email
     * FROM t_user
     * WHERE (name LIKE ? AND age < ?)
     */
    @Test
    void testLambda() {
        LambdaQueryWrapper<User> lambdaQ = Wrappers.lambdaQuery();
        lambdaQ.like(User::getName, "Jo") // 性别包含Jo
                 .lt(User::getAge, 30); // 年龄小于30
        List<User> list = userMapper. selectList(lambdaQ);
        list.forEach(System.out::println);
    }

    /**
     * lambda条件构造器
     * <p>
     * SELECT id , name, age , email, create_time
     * FROM t_user
     * WHERE name LIKE 'Jack%'
     * AND ( age < 18 OR email IS NOT NULL )
     */
    @Test
    void testLambda2() {
        List<User> list = new LambdaQueryChainWrapper<>(userMapper)
            .likeRight(User::getName, "Jo")
            .and(q -> q.lt(User::getAge, 30).or().isNotNull(User::getEmail)).list();
        list.forEach(System.out::println);
    }
}