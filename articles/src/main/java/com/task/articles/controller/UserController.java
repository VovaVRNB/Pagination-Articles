package com.task.articles.controller;

import com.task.articles.dto.UserDTO;
import com.task.articles.model.User;
import com.task.articles.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public Optional<User> getById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping("/register")
    public User create(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

}
