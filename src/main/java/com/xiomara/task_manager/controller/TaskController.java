package com.xiomara.task_manager.controller;

import com.xiomara.task_manager.dto.TaskRequestDTO; // <--- ESTA ES LA LÍNEA QUE FALTABA
import com.xiomara.task_manager.dto.TaskResponseDTO;
import com.xiomara.task_manager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        // Validación básica
        if (taskRequestDTO.getDescription() == null || taskRequestDTO.getDescription().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(taskService.createTask(taskRequestDTO), HttpStatus.CREATED);
    }
}
