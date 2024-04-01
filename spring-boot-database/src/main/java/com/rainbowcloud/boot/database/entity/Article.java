package com.rainbowcloud.boot.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DingYihang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // 表示这是一个实体类【必要】
@Table(name="t_article") // 表名可以省略
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 32)
    private String author;
    @Column(nullable = false,length = 32)
    private String title;
    @Column(nullable = false,length = 500)
    private String content;
}
