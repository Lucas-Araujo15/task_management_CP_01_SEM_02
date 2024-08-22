package com.api.taskmanagement.model;

public enum Status {
    PENDING("Pendente"),
    IN_PROGRESS("Em Andamento"),
    FINISHED("Concluída");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    private String getName() {
        return this.name;
    }
}
