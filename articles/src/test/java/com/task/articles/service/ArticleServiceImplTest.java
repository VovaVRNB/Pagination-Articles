package com.task.articles.service;

import com.task.articles.model.Article;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class ArticleServiceImplTest {

    @Autowired
    private ArticleService articleService;

    @Test
    void findAll() {
        Page<Article> articles = articleService.findAll(Optional.of(0), Optional.of("date"));
        Assert.assertNotNull(articles);
    }

    @Test
    void findAllByLastWeekFromDate() {
        Page<Article> articles = articleService.findAllByLastWeekFromDate("2022-07-02T14:13:37.225010Z", Optional.of(0), Optional.of("date"));
        Assert.assertNotNull(articles);
    }
}