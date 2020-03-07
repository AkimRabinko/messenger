package com.example.messenger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {
    int id;
    int userId;
    String name;
    String topic;
    List<String> tags;
    String mainText;
    LocalDateTime creationDate;
    List<String> images;

    @JsonCreator

    public Article(@JsonProperty("id") int id,
                   @JsonProperty("userId") int userId,
                   @JsonProperty("name") String name,
                   @JsonProperty("topic") String topic,
                   @JsonProperty("tags") List<String> tags,
                   @JsonProperty("mainText") String mainText,
                   @JsonProperty("creationDate") LocalDateTime creationDate,
                   @JsonProperty("images") List<String> images) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.topic = topic;
        this.tags = tags;
        this.mainText = mainText;
        this.creationDate = creationDate;
        this.images = images;
    }
}