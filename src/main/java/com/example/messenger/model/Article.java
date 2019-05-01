package com.example.messenger.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {
    private int id;
    private int userId;
    private String name;
    private String topic;
    private List<String> tags;
    private String mainText;
    private LocalDateTime creationDate;
    private List<String> images;
}
