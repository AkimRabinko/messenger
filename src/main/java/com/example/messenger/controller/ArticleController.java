package com.example.messenger.controller;

import com.example.messenger.model.Article;
import com.example.messenger.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("article")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public boolean saveArticle(Article article) {
        return articleService.saveArticle(article);
    }

    @PutMapping
    public boolean updateArticle(Article article) {
        return articleService.updateArticle(article);
    }

    @DeleteMapping("{id}")
    public boolean deleteArticle(@PathVariable int id) {
        return articleService.deleteArticle(id);
    }

    @GetMapping
    public Article getArticleByName(String name) {
        return articleService.getArticleByName(name);
    }

    @GetMapping("user/{userId}")
    public List<Article> getArticles(@PathVariable int userId) {
        return articleService.getArticles(userId);
    }

    @GetMapping("date")
    public List<Article> getArticles(LocalDateTime date) {
        return articleService.getArticles(date);
    }

    @GetMapping("period")
    public List<Article> getArticles(LocalDateTime start, LocalDateTime end) {
        return articleService.getArticles(start, end);
    }

    @GetMapping("tags")
    public List<Article> getArticles(String... tags) {
        return articleService.getArticles(tags);
    }
}
