package com.api.taskmanagement.controller.dto.status;

import com.api.taskmanagement.model.Status;
import com.api.taskmanagement.model.TaskStatus;

public record TaskStatusListDTO(
        Status nameStatus
) {
    public TaskStatusListDTO(TaskStatus taskStatus) {
        this(taskStatus.getNameStatus());
    }
}
