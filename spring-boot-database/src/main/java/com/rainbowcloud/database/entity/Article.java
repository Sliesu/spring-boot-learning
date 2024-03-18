package com.rainbowcloud.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    private Integer id;
    private String author;
    private String title;
    private String content;
}
