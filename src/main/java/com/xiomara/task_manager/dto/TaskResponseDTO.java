package com.xiomara.task_manager.dto;

import com.xiomara.task_manager.model.TaskStatus;

public class TaskResponseDTO {
    private Long id;
    private String description;
    private TaskStatus status;

    // Constructor, Getters y Setters
    public TaskResponseDTO(Long id, String description, TaskStatus status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }
    // Getters...
    public Long getId() { return id; }
    public String getDescription() { return description; }
    public TaskStatus getStatus() { return status; }
}
