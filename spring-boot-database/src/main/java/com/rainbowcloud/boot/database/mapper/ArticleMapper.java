package com.rainbowcloud.boot.database.mapper;

import com.rainbowcloud.boot.database.entity.Article;

import java.util.List;

/**
 * @author DingYihang
 */

public interface ArticleMapper {

    /**
     *查询所有的文章
     * @return List<Article> 文章列表
     */
    List<Article> selectArticleList();

    /**
     *通过id查询文章
     * @param id 文章id
     * @return Article 文章
     */
    Article selectArticleById(int id);

    /**
     * 新增文章
     * @param article 文章
     * @return 返回受影响的行数
     */
     int insertArticle(Article article);



    /**
     * 更新文章
     * @param article 文章
     * @return 返回受影响的行数
     */
     int updateArticle(Article article);

    /**
     * 删除文章
     * @param id 文章id
     * @return 返回受影响的行数
     */
     int deleteArticle(int id);

}
