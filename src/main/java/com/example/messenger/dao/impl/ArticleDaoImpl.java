package com.example.messenger.dao.impl;

import com.example.messenger.dao.ArticleDao;
import com.example.messenger.model.Article;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.messenger.dao.impl.DaoUtils.isUpdated;

@Repository
@AllArgsConstructor
public class ArticleDaoImpl implements ArticleDao {
    private static final String SAVE_ARTICLE = "INSERT INTO article (user_id, name, topic, main_text, creation_date) " +
            "VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_ARTICLE = "UPDATE article SET name = ?, topic = ?, main_text = ? WHERE id = ?;";
    private static final String DELETE_ARTICLE = "DELETE FROM article WHERE id = ?;";
    private static final String GET_ARTICLE_BY_NAME = "SELECT * FROM article WHERE name = ?;";
    private static final String GET_ARTICLES_BY_USER = "SELECT * FROM article WHERE user_id = ?;";
    private static final String GET_ARTICLES_BY_DATE = "SELECT * FROM article WHERE creation_date::DATE = ?;";
    private static final String GET_ARTICLES_BY_DPERIOD = "SELECT * FROM article WHERE creation_date >= ? AND creation_date <= ?;";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean saveArticle(Article article) {
        //
        return isUpdated(jdbcTemplate.update(SAVE_ARTICLE,
                article.getUserId(),
                article.getName(),
                article.getTopic(),
                article.getMainText(),
                article.getCreationDate()));
    }

    @Override
    public boolean updateArticle(Article article) {
        return isUpdated(jdbcTemplate.update(UPDATE_ARTICLE,
                article.getName(),
                article.getTopic(),
                article.getMainText(),
                article.getId()));
    }

    @Override
    public boolean deleteArticle(int id) {
        return isUpdated(jdbcTemplate.update(DELETE_ARTICLE, id));
    }

    @Override
    public Article getArticleByName(String name) {
        return jdbcTemplate.queryForObject(GET_ARTICLE_BY_NAME, Article.class);
    }

    @Override
    public List<Article> getArticles(int userId) {
        return jdbcTemplate.query(GET_ARTICLES_BY_USER, BeanPropertyRowMapper.newInstance(Article.class), userId);
    }

    @Override
    public List<Article> getArticles(LocalDate date) {
        return jdbcTemplate.query(GET_ARTICLES_BY_DATE, BeanPropertyRowMapper.newInstance(Article.class), date);
    }

    @Override
    public List<Article> getArticles(LocalDateTime start, LocalDateTime end) {
        return jdbcTemplate.query(GET_ARTICLES_BY_DPERIOD, BeanPropertyRowMapper.newInstance(Article.class), start, end);
    }
}
