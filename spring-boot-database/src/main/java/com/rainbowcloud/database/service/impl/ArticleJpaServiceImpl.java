package com.rainbowcloud.database.service.impl;

import com.rainbowcloud.database.dao.ArticleJpaDAO;
import com.rainbowcloud.database.entity.Article;
import com.rainbowcloud.database.service.ArticleJpaService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author DingYihang
 */
@Service
public class ArticleJpaServiceImpl implements ArticleJpaService {

    @Resource
    private ArticleJpaDAO articleJpaDA0;
    @Override
    public void saveArtcie(Article article) {
        articleJpaDA0.save(article);
    }

    @Override
    public void updataArticle(Article article) {
        articleJpaDA0.save(article);
    }

    @Override
    public void deleteArticleById(int id) {
        articleJpaDA0.deleteById(id);
    }

    @Override
    public Article getArticleById(int id) {
        Optional<Article> article0ptional = articleJpaDA0.findById(id);
        return article0ptional.orElse(null);

    }

    @Override
    public List<Article> findAll() {
        return articleJpaDA0.findAll();
    }
}
