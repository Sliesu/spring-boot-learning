package com.rainbowcloud.database.mapper;


import com.rainbowcloud.database.entity.Article;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Transactional
@SpringBootTest
class ArticleMapperTest {
    @Autowired
    private ArticleMapper articleMapper;

    private static final Logger log = LoggerFactory.getLogger(ArticleMapperTest.class);
    @Test
    void insertArticle() {
        Article article = Article.builder().author("dyh").title("spring boot").content("Spring Boot").build();
        articleMapper.insertArticle(article);
    }


    @Test
    void updateArticle() {
        Article article = Article.builder().author("dingyihang").title("spring boot").content("Spring Boot").id(1).build();
        articleMapper.updateArticle(article);
    }

    @Test
    void getArticleById() {
        Article article = articleMapper.selectArticleById(1);
        log.info(String.valueOf(article));
    }

    @Test
    void findAll() {
        List<Article> articleList = articleMapper.selectArticleList();
        log.info(articleList.toString());
    }

    @Test
    void deleteArticle() {
        articleMapper.deleteArticle(5);
    }
}