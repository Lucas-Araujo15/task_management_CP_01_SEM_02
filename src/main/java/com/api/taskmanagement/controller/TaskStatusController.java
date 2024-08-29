package com.api.taskmanagement.controller;

import com.api.taskmanagement.controller.dto.status.TaskStatusListDTO;
import com.api.taskmanagement.service.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TaskStatusController {
    private final TaskStatusService service;

    @Autowired
    public TaskStatusController(TaskStatusService service) {
        this.service = service;
    }

    @GetMapping("/public/status")
    public ResponseEntity<Page<TaskStatusListDTO>> findAll(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<TaskStatusListDTO> page = service.findAll(pagination);
        return ResponseEntity.ok(page);
    }
}
