package com.rainbowcloud.database.dao;

import com.rainbowcloud.database.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;


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

    @Test
    void updateById() {
        Article article = Article.builder()
                .author("DingYihang")
                .title("Spring Boot")
                .content("Spring Boot Content")
                .build();

        int n = articleJDBCDAO.updateById(article);
        log.info("Saved article with ID: {}", n);
    }

    @Test
    void findById() {
        long id;
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextLong();
        Article article = articleJDBCDAO.findById(id);
        log.info(article.toString());
    }

    @Test
    void findAll() {
        List<Article> articles = articleJDBCDAO.findAll();
        log.info(articles.toString());
    }

    @Test
    void deleteById() {
        long id;
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextLong();
        int n = articleJDBCDAO.deleteById(id);
        log.info("Saved article with ID: {}", n);
    }
}