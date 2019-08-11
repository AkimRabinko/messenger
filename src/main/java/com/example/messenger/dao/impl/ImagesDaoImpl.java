package com.example.messenger.dao.impl;

import com.example.messenger.dao.ImagesDao;
import com.example.messenger.dto.ArticleImageDto;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ImagesDaoImpl implements ImagesDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean saveArticleImage(ArticleImageDto articleImage) {
        return false;
    }

    @Override
    public boolean updateArticleImage(ArticleImageDto articleImage) {
        return false;
    }

    @Override
    public boolean deleteArticleImage(int id) {
        return false;
    }

    @Override
    public String getImageNameById(int id) {
        return null;
    }

    @Override
    public String getImageNameByImagePosition(int imagePositionId) {
        return null;
    }

    @Override
    public List<String> getImagesNames(int articleId) {
        return null;
    }
}
