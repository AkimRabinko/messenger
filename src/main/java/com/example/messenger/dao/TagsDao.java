package com.example.messenger.dao;

import java.util.List;

public interface TagsDao {
    boolean saveTag(String tag);

    boolean updateTag(int tagId, String tag);

    boolean deleteTag(int tagId);

    List<String> getTags();

    List<String> getTagsByArticle(int articleId);
}
