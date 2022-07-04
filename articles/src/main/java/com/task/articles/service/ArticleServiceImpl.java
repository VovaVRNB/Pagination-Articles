package com.task.articles.service;

import com.task.articles.dto.ArticleDTO;
import com.task.articles.model.Article;
import com.task.articles.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    private final ArticleRepository articleRepository;

    private final UserService userService;

    public ArticleServiceImpl(ArticleRepository articleRepository, UserService userService) {
        this.articleRepository = articleRepository;
        this.userService = userService;
    }

    @Override
    public Article save(ArticleDTO article) {
        logger.info("Saving article with current date : " + article.toString());
        return articleRepository.save(Article.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .date(ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT))
                .user(userService.findUserByName(SecurityContextHolder.getContext().getAuthentication().getName()))
                .build()
        );
    }

    @Override
    public Page<Article> findAll(Optional<Integer> page, Optional<String> sortBy) {
        logger.info("Looking for the articles");
        return articleRepository.findAll(PageRequest.of(page.orElse(0), 5, Sort.Direction.ASC, sortBy.orElse("id")));
    }

    @Override
    public void delete(Long id) {
        logger.info("Delete article with id : " + id);
        articleRepository.deleteById(id);
    }

    @Override
    public Page<Article> findAllByLastWeekFromDate(String date, Optional<Integer> page, Optional<String> sortBy) {
        final Optional<Instant> before = Optional.ofNullable(Instant.parse(date));
        final Optional<Instant> after = Optional.ofNullable(Instant.parse(date).minus(7L, ChronoUnit.DAYS));
        logger.info("Finding articles between dates : " + before + " and " + after);

        Specification<Article> inBetweenDates = null;

        if(before.isPresent() && after.isPresent()) {
            inBetweenDates = (root, query, cb) -> {
                return cb.between(root.get("date").as(Instant.class), after.get(), before.get());
            };
        }

        return articleRepository.findAll(inBetweenDates, PageRequest.of(page.orElse(0), 5, Sort.Direction.ASC, sortBy.orElse("date")));
    }

    @Override
    public Article findByTitle(String title) {
        return articleRepository.findByTitle(title);
    }
}
