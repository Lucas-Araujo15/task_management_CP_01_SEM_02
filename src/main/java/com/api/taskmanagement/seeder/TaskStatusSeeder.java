package com.api.taskmanagement.seeder;

import com.api.taskmanagement.model.Status;
import com.api.taskmanagement.model.TaskStatus;
import com.api.taskmanagement.repository.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TaskStatusSeeder implements CommandLineRunner {
    @Autowired
    private TaskStatusRepository taskStatusRepository;

    @Override
    public void run(String... args) throws Exception {
        seed();
    }

    private void seed() {
        var empty = 0;
        if (taskStatusRepository.count() == empty) {
            TaskStatus statusPending = new TaskStatus("Pendente", Status.PENDING.getKeyword());
            TaskStatus statusInProgress = new TaskStatus("Em Progresso", Status.IN_PROGRESS.getKeyword());
            TaskStatus statusFinished = new TaskStatus("Concluído", Status.FINISHED.getKeyword());

            taskStatusRepository.save(statusPending);
            taskStatusRepository.save(statusInProgress);
            taskStatusRepository.save(statusFinished);
        }
    }
}
