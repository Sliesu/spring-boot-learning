package com.rainbowcloud.boot.mapper;

import com.rainbowcloud.boot.entity.Clazz;

public interface ClazzMapper {
    /**
     * 根据班级id查询班级信息
     *
     * @param clazzId 班级id
     * @return 班级信息
     */
    Clazz getClazzOneToMany(int clazzId);

    /**
     * 根据id查询班级
     * @param clazzId 班级id
     * @return 班级对象（班级自身信息、班级教师信息、班级所有学生信息）
     */
    Clazz getClazz(int clazzId);
}