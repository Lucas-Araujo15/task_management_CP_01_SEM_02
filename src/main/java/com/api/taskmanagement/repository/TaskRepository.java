package com.api.taskmanagement.repository;

import com.api.taskmanagement.model.Task;
import com.api.taskmanagement.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByUser(User user, Pageable pagination);

    Optional<Task> findByIdAndUser(Long id, User user);

    void deleteByIdAndUser(Long id, User user);
}
