package com.api.taskmanagement.controller.dto.task;

import jakarta.validation.constraints.Future;

import java.time.LocalDateTime;

public record TaskUpdateDTO(
        String title,

        String description,

        @Future
        LocalDateTime deadline,

        Long taskStatusId
) {
}
