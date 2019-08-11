package com.example.messenger.dao.impl;

import com.example.messenger.dao.TagsDao;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TagsDaoImpl implements TagsDao {
    private final JdbcTemplate jdbcTemplate;

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
