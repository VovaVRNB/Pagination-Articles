package com.task.articles.dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
    private String title;
    private String content;
}
