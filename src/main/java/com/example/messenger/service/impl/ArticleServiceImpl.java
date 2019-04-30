package com.example.messenger.service.impl;

import com.example.messenger.dao.ArticleDao;
import com.example.messenger.model.Article;
import com.example.messenger.service.ArticleService;
import com.example.messenger.service.ImagesService;
import com.example.messenger.service.TagsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ImagesService imagesService;
    private final TagsService tagsServicel;
    private final ArticleDao articleDao;


    @Override
    public boolean saveArticle(Article article) {
        return false;
    }

    @Override
    public boolean updateArticle(Article article) {
        return false;
    }

    @Override
    public boolean deleteArticle(int id) {
        return false;
    }

    @Override
    public Article getArticleByName(String name) {
        return null;
    }

    @Override
    public List<Article> getArticles(int userId) {
        return null;
    }

    @Override
    public List<Article> getArticles(LocalDateTime date) {
        return null;
    }

    @Override
    public List<Article> getArticles(LocalDateTime start, LocalDateTime end) {
        return null;
    }

    @Override
    public List<Article> getArticles(String... tags) {
        return null;
    }
}
