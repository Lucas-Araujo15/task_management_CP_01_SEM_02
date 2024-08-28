package com.api.taskmanagement.service;

import com.api.taskmanagement.controller.dto.auth.RegisterUserDTO;
import com.api.taskmanagement.controller.dto.auth.RegisterUserListDTO;
import com.api.taskmanagement.model.User;
import com.api.taskmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {
    private final UserRepository repository;

    @Autowired
    public AuthenticationService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username);
    }

    public RegisterUserListDTO register(RegisterUserDTO dto) {
        User user = new User(dto);
        repository.save(user);

        return new RegisterUserListDTO(user);
    }
}
