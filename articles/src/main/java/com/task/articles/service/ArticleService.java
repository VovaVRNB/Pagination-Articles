package com.task.articles.service;

import com.task.articles.dto.ArticleDTO;
import com.task.articles.model.Article;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ArticleService {
    Article save(ArticleDTO article);
    Page<Article> findAll(Optional<Integer> page, Optional<String> sortBy);
    void delete(Long id);
    Page<Article> findAllByLastWeekFromDate(String date, Optional<Integer> page, Optional<String> sortBy);
    Article findByTitle(String title);
}
