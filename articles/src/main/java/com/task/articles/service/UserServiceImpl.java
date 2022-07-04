package com.task.articles.service;

import com.task.articles.dto.UserDTO;
import com.task.articles.model.User;
import com.task.articles.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        logger.info("Finding user by id : " + id);
        return userRepository.findById(id);
    }

    @Override
    public User save(UserDTO user) {
        logger.info("Saving user : " + user);
        return userRepository.save(User.builder()
                .name(user.getName())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(roleService.findByName("ROLE_USER"))
                .build()
        );
    }

    @Override
    public User findUserByName(String name) {
        logger.info("Finding user by name : " + name);
        return userRepository.findUserByName(name);
    }

    @Override
    public User deleteByName(String name) {
        return userRepository.deleteByName(name);
    }
}
