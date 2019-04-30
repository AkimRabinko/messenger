package com.example.messenger.dao;

import com.example.messenger.dto.ArticleImageDto;

import java.util.List;

public interface ImagesDao {
    boolean saveArticleImage(ArticleImageDto articleImage);

    boolean updateArticleImage(ArticleImageDto articleImage);

    boolean deleteArticleImage(int id);

    String getImageNameById(int id);

    String getImageNameByImagePosition(int imagePositionId);

    List<String> getImagesNames(int articleId);
}
