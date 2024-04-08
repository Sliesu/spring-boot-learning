package com.rbc.boot.exception.entity;

import com.rbc.boot.exception.annotation.Email;
import com.rbc.boot.exception.annotation.Gender;
import com.rbc.boot.exception.annotation.IDCard;
import com.rbc.boot.exception.annotation.Phone;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;



/**
 * @author DingYihang
 */
@Data
public class User {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Max(value = 100, message = "年龄不能超过100岁")
    @Min(value = 1, message = "年龄不能小于1岁")
    private int age;

    @Phone
    private String phone;

    /**
     * 身份证
     */
    @IDCard
    private String idCard;

    /**
     * 性别
     */
    @Gender
    private String gender;
}