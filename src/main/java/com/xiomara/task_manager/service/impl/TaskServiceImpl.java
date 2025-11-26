package com.xiomara.task_manager.service.impl;

import com.xiomara.task_manager.dto.TaskRequestDTO;
import com.xiomara.task_manager.dto.TaskResponseDTO;
import com.xiomara.task_manager.mapper.TaskMapper;
import com.xiomara.task_manager.model.Task;
import com.xiomara.task_manager.service.TaskService;
import com.xiomara.task_manager.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    // Inyección por Constructor (Cumple SonarQube y hace la clase testable)
    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    @Transactional(readOnly = true) // Optimización de rendimiento
    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional // Garantiza atomicidad
    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        Task task = taskMapper.toEntity(taskRequestDTO);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDTO(savedTask);
    }
}