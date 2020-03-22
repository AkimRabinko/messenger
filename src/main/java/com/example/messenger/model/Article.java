package com.example.messenger.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
@JsonDeserialize(builder = Article.ArticleBuilder.class)
public class Article {
    int id;
    int userId;
    String name;
    String topic;
    List<String> tags;
    String mainText;
    LocalDateTime creationDate;
    List<String> images;

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ArticleBuilder {
    }
}