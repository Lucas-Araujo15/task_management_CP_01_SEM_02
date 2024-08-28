package com.api.taskmanagement.service;

import com.api.taskmanagement.controller.dto.status.TaskStatusListDTO;
import com.api.taskmanagement.model.TaskStatus;
import com.api.taskmanagement.repository.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskStatusService {
    private final TaskStatusRepository repository;

    @Autowired
    public TaskStatusService(TaskStatusRepository repository) {
        this.repository = repository;
    }

    public TaskStatus findById(Long id) {
        return repository.getReferenceById(id);
    }
}
