package com.api.taskmanagement.controller.dto.auth;

public record TokenJwtDTO(
        String token
) {
    public TokenJwtDTO(String token) {
        this.token = token;
    }
}
