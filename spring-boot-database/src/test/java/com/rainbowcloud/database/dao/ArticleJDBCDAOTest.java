package com.rainbowcloud.database.dao;

import com.rainbowcloud.database.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootTest
class ArticleJDBCDAOTest {

    private static final Logger log = LoggerFactory.getLogger(ArticleJDBCDAOTest.class);

    @Autowired
    private ArticleJDBCDAO articleJDBCDAO;

    @Test
    void saveArticle() {
        Article article = Article.builder()
                .author("DingYihang")
                .title("Spring Boot")
                .content("Spring Boot Content")
                .build();

        int n = articleJDBCDAO.updateById(article);
        log.info("Saved article with ID: {}", n);

    }
}