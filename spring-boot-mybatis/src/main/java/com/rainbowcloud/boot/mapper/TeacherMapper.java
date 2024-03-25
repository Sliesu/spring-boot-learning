package com.rainbowcloud.boot.mapper;

import com.rainbowcloud.boot.entity.Teacher;

public interface TeacherMapper {
    /**
     * 根据id查询教师信息（一对一，关联查询出其管理的班级对象信息）
     *
     * @param teacherId 教师id
     * @return 教师对象
     */
    Teacher selectOneByOne(int teacherId);
}
