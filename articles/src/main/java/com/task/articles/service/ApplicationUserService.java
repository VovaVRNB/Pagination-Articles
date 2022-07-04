package com.task.articles.service;

import com.task.articles.model.ApplicationUser;
import com.task.articles.model.User;
import com.task.articles.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final UserRepository userRepository;

    public ApplicationUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByName(username);
        return new ApplicationUser(
                user.getName(),
                user.getPassword(),
                new HashSet<>(Arrays.asList(new SimpleGrantedAuthority(user.getRole().getName()))),
                true,
                true,
                true,
                true
                );
    }
}