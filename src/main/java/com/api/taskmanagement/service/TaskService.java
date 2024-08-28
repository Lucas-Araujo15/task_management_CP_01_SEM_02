package com.api.taskmanagement.service;

import com.api.taskmanagement.controller.dto.task.TaskListDTO;
import com.api.taskmanagement.controller.dto.task.TaskRegisterDTO;
import com.api.taskmanagement.model.Task;
import com.api.taskmanagement.model.TaskStatus;
import com.api.taskmanagement.model.User;
import com.api.taskmanagement.repository.TaskRepository;
import com.api.taskmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository repository, UserRepository userRepository, TokenService tokenService, TaskStatusService taskStatusService) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public TaskListDTO create(TaskRegisterDTO dto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        User user = (User) userRepository.findByUsername(username);

        Task task = new Task(dto);
        TaskStatus taskStatus = new TaskStatus();

        taskStatus.setId(dto.taskStatusId());

        task.setUser(user);
        task.setTaskStatus(taskStatus);

        repository.save(task);

        return new TaskListDTO(task);
    }

    public TaskListDTO findById(Long id) {
        return new TaskListDTO(repository.getReferenceById(id));
    }

    public Page<TaskListDTO> findAll(Pageable pagination) {
        return repository.findAll(pagination).map(TaskListDTO::new);
    }

//    public TaskListDTO update(TaskUpdateDTO dto, Long id) {
//
//    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
