package com.rbc.boot.mybatisplus.entity;

import com.baomidou. mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DingYihang
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_user")
    public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
