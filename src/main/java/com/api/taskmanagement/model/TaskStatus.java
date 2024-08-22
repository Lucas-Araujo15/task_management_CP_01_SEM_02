package com.api.taskmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "T_TM_TASK_STATUS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_task_status", nullable = false, unique = true)
    private Long id;

    @Column(name = "nm_status", nullable = false)
    private Status nameStatus;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_status_id")
    private List<Task> taskList;
}
