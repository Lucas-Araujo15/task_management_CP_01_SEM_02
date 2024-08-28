package com.api.taskmanagement.controller.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterUserDTO(
        @NotBlank
        String name,

        @NotBlank
        @Email
        String username,

        @NotBlank
        String password
) {
}
