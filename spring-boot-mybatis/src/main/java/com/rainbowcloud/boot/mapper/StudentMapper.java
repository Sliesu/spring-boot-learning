package com.rainbowcloud.boot.mapper;

import com.rainbowcloud.boot.entity.Student;
import org.apache.ibatis.annotations.Param;


import java.util.List;


/**
 * @author DingYihang
 */
public interface StudentMapper {
    /**
     * 插入一条学生信息
     *
     * @param student 学生对象
     * @return 收影响的行数
     */
    int insert(Student student);

    /**
     * 更具学生ID查找学生信息
     *
     * @param studentId 学生ID
     * @return 学生对象
     */
    Student findStudentById(int studentId);

    /**
     * 根据学生ID更新学生信息
     *
     * @param student 学生对象
     * @return 收影响的行数
     */
    int updateById(Student student);

    /**
     * 根据学生ID删除学生信息
     *
     * @param studentId 学生ID
     * @return 收影响的行数
     */
    int deleteById(int studentId);

    /**
     * 查询所有学生信息
     *
     * @param students  学生列表
     * @return 收影响的行数
     */
    int batchInsert(@Param("students") List<Student> students);

    /**
     * 批删除学生信息
     *
     * @param ids 学生ID列表
     * @return 收影响的行数
     */
    int batchDelete(@Param("idList") List<Integer> ids);

    /**
     * 批更新学生信息
     * @param students 学生列表
     * @return 收影响的行数
     */
    int batchUpdate(@Param("students") List<Student> students);

    /**
     * 模糊查询学生信息
     *
     * @param student 学生信息关键字段
     * @return 学生列表
     */
    List<Student> selectByDynamicSql(Student student);

    /**
     * 根据学生id查询（关联查询所属班级信息）
     *
     * @param studentId 学生id
     * @return 学生对象
     */
    Student getStudentManyToOne(int studentId);

    /**
     * 根据学生id查询（关联查询出所属班级信息，所选课程信息）
     *
     * @param studentId 学生id
     * @return 学生对象
     */
    Student getStudent(int studentId);
}
