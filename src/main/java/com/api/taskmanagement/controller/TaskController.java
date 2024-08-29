package com.api.taskmanagement.controller;

import com.api.taskmanagement.controller.dto.auth.RegisterUserListDTO;
import com.api.taskmanagement.controller.dto.task.TaskListDTO;
import com.api.taskmanagement.controller.dto.task.TaskRegisterDTO;
import com.api.taskmanagement.controller.dto.task.TaskUpdateDTO;
import com.api.taskmanagement.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RegisterUserListDTO> create(@RequestBody @Valid TaskRegisterDTO dto, UriComponentsBuilder uriBuilder) {
        TaskListDTO task = service.create(dto);

        URI uri = uriBuilder.path("/api/tasks/{id}").buildAndExpand(task.id()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<TaskListDTO>> findAll(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<TaskListDTO> taskList = service.findAll(pagination);
        return ResponseEntity.ok(taskList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskListDTO> update(@RequestBody @Valid TaskUpdateDTO dto, @PathVariable("id") Long id) {
        TaskListDTO updatedTask = service.update(dto, id);
        return ResponseEntity.ok(updatedTask);
    }
}
