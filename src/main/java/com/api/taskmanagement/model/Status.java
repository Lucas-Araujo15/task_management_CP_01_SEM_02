package com.api.taskmanagement.model;

public enum Status {
    PENDING("pending"),
    IN_PROGRESS("in_progress"),
    FINISHED("finished");

    private final String keyword;

    Status(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return this.keyword;
    }
}
