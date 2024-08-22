package com.api.taskmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "T_TM_TASK")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_task", nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "tx_description", nullable = false)
    private String description;

    @Column(name = "dt_created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "dt_deadline", nullable = false)
    private LocalDateTime deadline;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_status_id")
    private TaskStatus taskStatus;
}
