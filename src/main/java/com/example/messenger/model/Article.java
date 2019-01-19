package com.example.messenger.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class Article {
    private int id;
    private int userId;
    private String name;
    private String topic;
    private List<String> tags;
    private String mainText;
    private Date articleDate;
    private List<String> images;
}
