package com.api.taskmanagement.controller;

import com.api.taskmanagement.service.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task-status")
public class TaskStatusController {
    private final TaskStatusService service;

    @Autowired
    public TaskStatusController(TaskStatusService service) {
        this.service = service;
    }
}
