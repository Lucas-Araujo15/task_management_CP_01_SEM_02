package com.api.taskmanagement.service;

import com.api.taskmanagement.controller.dto.task.TaskListDTO;
import com.api.taskmanagement.controller.dto.task.TaskRegisterDTO;
import com.api.taskmanagement.controller.dto.task.TaskUpdateDTO;
import com.api.taskmanagement.model.Status;
import com.api.taskmanagement.model.Task;
import com.api.taskmanagement.model.TaskStatus;
import com.api.taskmanagement.model.User;
import com.api.taskmanagement.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class TaskService {
    private final TaskRepository repository;
    private final TaskStatusService taskStatusService;
    private final UserService userService;

    @Autowired
    public TaskService(TaskRepository repository, TokenService tokenService, TaskStatusService taskStatusService, UserService userService) {
        this.repository = repository;
        this.taskStatusService = taskStatusService;
        this.userService = userService;
    }

    public TaskListDTO create(TaskRegisterDTO dto) {
        User user = userService.getLoggedUser();

        Task task = new Task(dto);
        TaskStatus taskStatus = taskStatusService.findByKeyword(Status.PENDING.getKeyword());

        task.setUser(user);
        task.setTaskStatus(taskStatus);

        repository.save(task);

        return new TaskListDTO(task);
    }

    public TaskListDTO findById(Long id) {
        return new TaskListDTO(repository.getReferenceById(id));
    }

    public Page<TaskListDTO> findAll(Pageable pagination) {
        User user = userService.getLoggedUser();
        return repository.findByUser(user, pagination).map(TaskListDTO::new);
    }

    public TaskListDTO update(TaskUpdateDTO dto, Long id) {
        User user = userService.getLoggedUser();
        Task task = repository.findByIdAndUser(id, user).orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada!"));

        task.updateInformation(dto);

        if (dto.taskStatusId() != null) {
            TaskStatus taskStatus = taskStatusService.findById(dto.taskStatusId());
            task.setTaskStatus(taskStatus);
        }

        repository.save(task);

        return new TaskListDTO(task);
    }

    public void delete(Long id) {
        User user = userService.getLoggedUser();
        Task task = repository.findByIdAndUser(id, user).orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada!"));

        repository.delete(task);
    }
}
