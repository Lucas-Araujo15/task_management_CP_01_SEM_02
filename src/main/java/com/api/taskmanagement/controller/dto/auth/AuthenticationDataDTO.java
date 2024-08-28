package com.api.taskmanagement.controller.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDataDTO(
        @NotBlank
        String username,

        @NotBlank
        String password
) {
}
