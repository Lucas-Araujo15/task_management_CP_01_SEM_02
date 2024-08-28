package com.api.taskmanagement.controller.dto.auth;

import com.api.taskmanagement.model.User;

public record RegisterUserListDTO(
        String name,
        String email
) {
    public RegisterUserListDTO(User user) {
        this(user.getName(), user.getUsername());
    }
}
