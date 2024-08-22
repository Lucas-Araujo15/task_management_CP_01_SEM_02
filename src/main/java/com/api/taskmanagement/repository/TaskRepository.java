package com.api.taskmanagement.repository;

import com.api.taskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
