package com.example.messenger.service.impl;

import com.example.messenger.dao.ImagesDao;
import com.example.messenger.dto.ArticleImageDto;
import com.example.messenger.service.ImagesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImagesServiceImpl implements ImagesService {
    private final ImagesDao imagesDao;

    @Override
    public boolean saveArticleImage(ArticleImageDto articleImage) {
        return imagesDao.saveArticleImage(articleImage);
    }

    @Override
    public boolean updateArticleImage(ArticleImageDto articleImage) {
        return imagesDao.updateArticleImage(articleImage);
    }

    @Override
    public boolean deleteArticleImage(int id) {
        return imagesDao.deleteArticleImage(id);
    }

    @Override
    public String getImageNameById(int id) {
        return imagesDao.getImageNameById(id);
    }

    @Override
    public String getImageNameByImagePosition(int imagePositionId) {
        return imagesDao.getImageNameByImagePosition(imagePositionId);
    }

    @Override
    public List<String> getImagesNames(int articleId) {
        return imagesDao.getImagesNames(articleId);
    }
}
