package com.example.messenger.dao.impl;

import com.example.messenger.dao.ArticleDao;
import com.example.messenger.model.Article;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.messenger.dao.impl.DaoUtils.isUpdated;
import static com.example.messenger.jooqData.tables.Article.ARTICLE;

@Repository
@RequiredArgsConstructor
public class ArticleDaoImpl implements ArticleDao {
    private final DSLContext dslContext;

    @Override
    public boolean saveArticle(Article article) {
        return isUpdated(dslContext.insertInto(ARTICLE)
                .set(ARTICLE.ID, article.getId())
                .set(ARTICLE.NAME, article.getName())
                .set(ARTICLE.TOPIC, article.getTopic())
                .set(ARTICLE.MAIN_TEXT, article.getMainText())
                .set(ARTICLE.CREATION_DATE, article.getCreationDate())
                .execute());
    }

    @Override
    public boolean updateArticle(Article article) {
        return isUpdated(dslContext.update(ARTICLE)
                .set(ARTICLE.NAME, article.getName())
                .set(ARTICLE.TOPIC, article.getTopic())
                .set(ARTICLE.MAIN_TEXT, article.getMainText())
                .where(ARTICLE.ID.eq(article.getId()))
                .execute());
    }

    @Override
    public boolean deleteArticle(int id) {
        return isUpdated(dslContext.deleteFrom(ARTICLE)
                .where(ARTICLE.ID.eq(id))
                .execute());
    }

    @Override
    public Optional<Article> getArticleByName(String name) {
        return dslContext.selectFrom(ARTICLE)
                .where(ARTICLE.NAME.eq(name))
                .fetchOptionalInto(Article.class);
    }

    @Override
    public List<Article> getArticles(int userId) {
        return dslContext.selectFrom(ARTICLE)
                .where(ARTICLE.USER_ID.eq(userId))
                .fetchInto(Article.class);
    }

    @Override
    public List<Article> getArticles(LocalDate date) {
        return dslContext.selectFrom(ARTICLE)
                .where(ARTICLE.CREATION_DATE.cast(LocalDate.class).eq(date))
                .fetchInto(Article.class);
    }

    @Override
    public List<Article> getArticles(LocalDateTime start, LocalDateTime end) {
        return dslContext.selectFrom(ARTICLE)
                .where(ARTICLE.CREATION_DATE.between(start, end))
                .fetchInto(Article.class);
    }
}
