package com.task.articles.repository;

import com.task.articles.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaSpecificationExecutor<Article>, JpaRepository<Article, Long> {
    Article findByTitle(String title);
}
