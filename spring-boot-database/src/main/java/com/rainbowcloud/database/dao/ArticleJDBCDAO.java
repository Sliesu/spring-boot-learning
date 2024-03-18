package com.rainbowcloud.database.dao;

import com.rainbowcloud.database.entity.Article;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DingYihang
 */
@Repository
public class ArticleJDBCDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 更新文章
     * @param article 入参对象
     * @return 受影响的记录行数
     */
    public int updateById(Article article) {
        String sql = "UPDATE t_article SET author = ?, title = ?, content = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getId()
        );
    }

    /**
     * 根据id 查找文章
     * @param id 文章id
     * @return 文章对象
     */
    public Article findById(Long id) {
        // queryForObject用于查询单条记录返回结果
        String sql = "SELECT * FROM t_article WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Article.class));
    }

    /**
     * 查询所有文章
     * @return 文章集合
     */
    public List<Article> findAll() {
        // query用于查询结果列表
        String sql = "SELECT * FROM t_article";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Article.class));
    }

    /**
     * 根据id 删除文章
     * @param id 文章id
     * @return 受影响的记录行数
     */
    public int deleteById(Long id) {
        String sql = "DELETE FROM t_article WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }


}
