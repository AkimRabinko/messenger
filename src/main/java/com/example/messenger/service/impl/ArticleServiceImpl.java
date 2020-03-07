package com.example.messenger.service.impl;

import com.example.messenger.dao.ArticleDao;
import com.example.messenger.model.Article;
import com.example.messenger.service.ArticleService;
import com.example.messenger.service.ImagesService;
import com.example.messenger.service.TagsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ImagesService imagesService;
    private final TagsService tagsService;
    private final ArticleDao articleDao;


    @Override
    public boolean saveArticle(Article article) {
        return articleDao.saveArticle(article);
    }

    @Override
    public boolean updateArticle(Article article) {
        return articleDao.updateArticle(article);
    }

    @Override
    public boolean deleteArticle(int id) {
        return articleDao.deleteArticle(id);
    }

    @Override
    public Article getArticleByName(String name) {
        return articleDao.getArticleByName(name)
                .orElseThrow();
    }

    @Override
    public List<Article> getArticles(int userId) {
        return articleDao.getArticles(userId);
    }

    @Override
    public List<Article> getArticles(LocalDate date) {
        return articleDao.getArticles(date);
    }

    @Override
    public List<Article> getArticles(LocalDateTime start, LocalDateTime end) {
        return articleDao.getArticles(start, end);
    }

    @Override
    public List<Article> getArticles(String... tags) {
        return null;
    }
}
