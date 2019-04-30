package com.example.messenger.service;

import java.util.List;

public interface TagsService {
    void saveTags(String... tags);

    boolean updateTag(int tagId, String tag);

    boolean deleteTag(int tagId);

    List<String> getTags();

    List<String> getTagsByArticle(int articleId);
}
