package com.api.taskmanagement.controller.dto.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TaskRegisterDTO(
        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull
        LocalDateTime deadline,

        @NotNull
        Long taskStatusId
) {
}
