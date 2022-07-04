package com.task.articles.service;

import com.task.articles.dto.UserDTO;
import com.task.articles.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void findUserById() {
        Optional<User> user = userService.findUserById(1L);
        Assert.assertEquals(Optional.of(1L), user.map(User::getId));
    }

    @Test
    void findUserByName() {
        if (userService.findUserByName("Test") == null) {
            UserDTO user = new UserDTO();
            user.setName("Test");
            user.setPassword("Test");
            userService.save(user);
        }
        Assert.assertNotNull(userService.findUserByName("Test"));
    }
}