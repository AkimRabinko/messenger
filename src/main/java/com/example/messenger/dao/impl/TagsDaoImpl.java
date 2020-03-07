package com.example.messenger.dao.impl;

import com.example.messenger.dao.TagsDao;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TagsDaoImpl implements TagsDao {
    private final DSLContext dslContext;

    @Override
    public boolean saveTag(String tag) {
        return false;
    }

    @Override
    public boolean updateTag(int tagId, String tag) {
        return false;
    }

    @Override
    public boolean deleteTag(int tagId) {
        return false;
    }

    @Override
    public List<String> getTags() {
        return null;
    }

    @Override
    public List<String> getTagsByArticle(int articleId) {
        return null;
    }
}
