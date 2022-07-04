package com.task.articles.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoleServiceImplTest {

    @Autowired
    private RoleService roleService;

    @Test
    void findByName() {
        Assert.assertEquals(Optional.of(1L), Optional.ofNullable(roleService.findByName("ROLE_ADMIN").getId()));
        Assert.assertEquals(Optional.of(2L), Optional.ofNullable(roleService.findByName("ROLE_USER").getId()));
    }
}