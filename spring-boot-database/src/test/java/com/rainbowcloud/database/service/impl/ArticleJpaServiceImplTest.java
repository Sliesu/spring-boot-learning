package com.rainbowcloud.database.service.impl;

import com.rainbowcloud.database.entity.Article;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DEZ
 * @DATE 2024/3/18
 */
@SpringBootTest
@Slf4j
class ArticleJpaServiceImplTest {
    @Resource
    private ArticleJpaServiceImpl articleJAPService;

    @Test
    void saveArticle() {
        Article article = Article.builder()
                .author("dyh")
                .title("Spring Boot JPA")
                .content("Spring Boot JPA")
                .build();
        articleJAPService.saveArtcie(article);
    }

    @Test
    void updateArticle() {
        Article article = Article.builder()
                .id(3)
                .author("dyh")
                .title("Spring Boot JPA 2")
                .content("Spring Boot JPA 2")
                .build();
        articleJAPService.updataArticle(article);
    }

    @Test
    void getArticleById() {
        Article article = articleJAPService.getArticleById(1);
        log.info(article.toString());
    }

    @Test
    void findAll() {
        List<Article> list = articleJAPService.findAll();
        list.forEach(System.out::println);
    }

    @Test
    void deleteArticleById() {
        articleJAPService.deleteArticleById(13);
    }
}
