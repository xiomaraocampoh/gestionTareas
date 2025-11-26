package com.xiomara.task_manager.mapper;

import com.xiomara.task_manager.dto.TaskRequestDTO;
import com.xiomara.task_manager.dto.TaskResponseDTO;
import com.xiomara.task_manager.model.Task;
import com.xiomara.task_manager.model.TaskStatus;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task toEntity(TaskRequestDTO dto) {
        Task task = new Task();
        task.setDescription(dto.getDescription());
        task.setStatus(TaskStatus.PENDIENTE); // Estado por defecto
        return task;
    }

    public TaskResponseDTO toDTO(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getDescription(),
                task.getStatus()
        );
    }
}