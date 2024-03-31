package com.rbc.boot.springbootmp.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author DingYihang
 */
@Data
@Accessors(chain = true)
@TableName("user")
public class UserDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;


    @TableField("phone")
    private String phone;

    @TableField("gender")
    private String gander;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 删除
     * 0-未删除 1-已删除
     */
    @TableField("deleted")
    private Integer deleted;

}
