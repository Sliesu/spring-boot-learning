package com.rainbowcloud.database.dao;

import com.rainbowcloud.boot.database.dao.ArticleJpaDAO;
import com.rainbowcloud.boot.database.entity.Article;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

import java.util.List;


class ArticleJpaDAOTest {

    @Resource
    private ArticleJpaDAO articleJpaDAO;

    @Test
    void findArticleByAuthor() {
        Article article = articleJpaDAO.findArticleByAuthor("dyh");
        System.out.println("**************************************************************");
        System.out.println(article);
        System.out.println("**************************************************************");
    }

    @Test
    void findArticleByAuthorContaining() {
        List<Article> list = articleJpaDAO.findArticleByAuthorContaining("dyh") ;
        System.out.println("**************************************************************");
        list.forEach(System.out::println);
        System.out.println("**************************************************************");
    }
}