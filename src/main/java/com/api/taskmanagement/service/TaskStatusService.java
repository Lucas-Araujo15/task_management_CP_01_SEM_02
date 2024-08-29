package com.api.taskmanagement.service;

import com.api.taskmanagement.controller.dto.status.TaskStatusListDTO;
import com.api.taskmanagement.controller.dto.task.TaskListDTO;
import com.api.taskmanagement.model.Status;
import com.api.taskmanagement.model.TaskStatus;
import com.api.taskmanagement.repository.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<TaskStatusListDTO> findAll(Pageable pagination) {
        return repository.findAll(pagination).map(TaskStatusListDTO::new);
    }

    public TaskStatus findByKeyword(String keyword) {
        return repository.findByKeyword(keyword);
    }
}
