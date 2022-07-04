package com.task.articles.repository;

import com.task.articles.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findRoleByName(String name);
}
