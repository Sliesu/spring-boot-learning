package com.rainbowcloud.boot.database.dao;

import com.rainbowcloud.boot.database.entity.Article;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author DingYihang
 */
@SpringBootApplication
public interface ArticleJpaDAO extends JpaRepository<Article,Integer> {

    Article findArticleByAuthor(String author);

    List<Article> findArticleByAuthorContaining(String keywords);


}
