package com.rainbowcloud.database.service;

import com.rainbowcloud.database.entity.Article;

import java.util.List;

public interface ArticleJpaService {
    /**
     * @param article
     * @return 文章对象
     */
    void saveArtcie(Article article);

    void updataArticle(Article article);

    void deleteArticleById(int id);

    Article getArticleById(int id);

    public List<Article> findAll();
}
