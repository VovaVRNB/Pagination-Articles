package com.task.articles.repository;

import com.task.articles.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByName(String name);
    User deleteByName(String name);
}
