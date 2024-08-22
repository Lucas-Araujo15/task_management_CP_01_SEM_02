package com.api.taskmanagement.repository;

import com.api.taskmanagement.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
}
