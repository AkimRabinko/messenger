package com.example.messenger.dao;

import com.example.messenger.model.Article;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ArticleDao {
    boolean saveArticle(Article article);

    boolean updateArticle(Article article);

    boolean deleteArticle(int id);

    Article getArticleByName(String name);

    List<Article> getArticles(int userId);

    List<Article> getArticles(LocalDate date);

    List<Article> getArticles(LocalDateTime start, LocalDateTime end);
}
