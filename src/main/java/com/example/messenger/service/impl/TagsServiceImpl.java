package com.example.messenger.service.impl;

import com.example.messenger.dao.TagsDao;
import com.example.messenger.service.TagsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagsServiceImpl implements TagsService {
    private final TagsDao tagsDao;

    @Override
    public void saveTags(String... tags) {
        for (String tag : tags) {
            tagsDao.saveTag(tag);
        }
    }

    @Override
    public boolean updateTag(int tagId, String tag) {
        return tagsDao.updateTag(tagId, tag);
    }

    @Override
    public boolean deleteTag(int tagId) {
        return tagsDao.deleteTag(tagId);
    }

    @Override
    public List<String> getTags() {
        return tagsDao.getTags();
    }

    @Override
    public List<String> getTagsByArticle(int articleId) {
        return tagsDao.getTagsByArticle(articleId);
    }
}
