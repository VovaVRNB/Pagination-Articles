package com.task.articles.service;

import com.task.articles.model.Role;
import com.task.articles.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role findByName(String name) {
        return repository.findRoleByName(name);
    }
}
