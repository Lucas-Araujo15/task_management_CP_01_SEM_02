package com.api.taskmanagement.controller.dto.task;

import com.api.taskmanagement.controller.dto.status.TaskStatusListDTO;
import com.api.taskmanagement.model.Task;
import com.api.taskmanagement.model.TaskStatus;

import java.time.LocalDateTime;

public record TaskListDTO(
        Long id,
        String title,
        String description,
        LocalDateTime createdAt,
        LocalDateTime deadline,
        TaskStatusListDTO taskStatus
) {
    public TaskListDTO(Task task) {
        this(task.getId(), task.getTitle(), task.getDescription(), task.getCreatedAt(),
                task.getDeadline(), new TaskStatusListDTO(task.getTaskStatus()));
    }
}
