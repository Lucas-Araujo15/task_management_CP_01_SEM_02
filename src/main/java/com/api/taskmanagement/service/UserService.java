package com.api.taskmanagement.service;

import com.api.taskmanagement.controller.dto.auth.RegisterUserDTO;
import com.api.taskmanagement.controller.dto.auth.RegisterUserListDTO;
import com.api.taskmanagement.model.User;
import com.api.taskmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterUserListDTO register(RegisterUserDTO dto) {
        User user = repository.save(new User(dto.username(), dto.name(), passwordEncoder.encode(dto.password())));

        return new RegisterUserListDTO(user);
    }

    public User getLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (User) auth.getPrincipal();
    }
}
