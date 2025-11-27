package com.xiomara.task_manager.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private int status;

    public ErrorResponse(String message, int status) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.status = status;
    }

    // Getters y Setters necesarios para que Jackson convierta a JSON
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getMessage() { return message; }
    public int getStatus() { return status; }
}