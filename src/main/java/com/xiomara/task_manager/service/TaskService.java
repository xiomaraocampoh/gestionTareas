package com.xiomara.task_manager.service;

import com.xiomara.task_manager.dto.TaskRequestDTO;
import com.xiomara.task_manager.dto.TaskResponseDTO;
import java.util.List;

public interface TaskService {
    List<TaskResponseDTO> getAllTasks();
    TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO);
}
