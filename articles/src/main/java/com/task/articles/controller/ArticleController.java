package com.task.articles.controller;

import com.task.articles.dto.ArticleDTO;
import com.task.articles.model.Article;
import com.task.articles.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public Article createArticle(@RequestBody ArticleDTO article) {
        return articleService.save(article);
    }

    @GetMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public Page<Article> getAll(@RequestParam Optional<Integer> page,
                                @RequestParam Optional<String> sortBy) {
        return articleService.findAll(page, sortBy);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteArticle(@PathVariable Long id) {
        articleService.delete(id);
    }

    @PutMapping()
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Page<Article> getAllAtLastWeek(@RequestBody String date,
                                                 @RequestParam Optional<Integer> page,
                                                 @RequestParam Optional<String> sortBy) {
        return articleService.findAllByLastWeekFromDate(date, page, sortBy);
    }
}
