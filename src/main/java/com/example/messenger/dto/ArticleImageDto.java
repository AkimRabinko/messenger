package com.example.messenger.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleImageDto {
    private int articleId;
    private String imagePositionId;
    private String imageName;
}
