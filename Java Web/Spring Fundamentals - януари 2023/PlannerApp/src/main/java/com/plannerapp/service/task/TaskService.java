package com.plannerapp.service.task;

import com.plannerapp.model.dto.AddTaskDTO;
import com.plannerapp.model.entity.TaskEntity;

import java.util.Set;

public interface TaskService {
    void addTask(AddTaskDTO addTaskDTO);

    Set<TaskEntity> findAllAvailableTasks();

    void assignTask(Long id);

    void removeTask(Long id);

    void returnTask(Long id);
}
