package com.api.taskmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String nameStatus;

    @Column(name = "ds_keyword", nullable = false, unique = true)
    private String keyword;

    public TaskStatus(String nameStatus, String keyword) {
        this.nameStatus = nameStatus;
        this.keyword = keyword;
    }
}
