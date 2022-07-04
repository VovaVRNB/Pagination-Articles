package com.task.articles.service;

import com.task.articles.model.Role;

public interface RoleService {
    Role findByName(String name);
}
