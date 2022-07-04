package com.task.articles.service;

import com.task.articles.dto.UserDTO;
import com.task.articles.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserById(Long id);
    User save(UserDTO user);
    User findUserByName(String name);
    User deleteByName(String name);

}
