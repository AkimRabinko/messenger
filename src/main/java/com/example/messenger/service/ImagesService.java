package com.example.messenger.service;

import com.example.messenger.dto.ArticleImageDto;

import java.util.List;

public interface ImagesService {
    boolean saveArticleImage(ArticleImageDto articleImage);

    boolean updateArticleImage(ArticleImageDto articleImage);

    boolean deleteArticleImage(int id);

    String getImageNameById(int id);

    String getImageNameByImagePosition(int imagePositionId);

    List<String> getImagesNames(int articleId);
}
