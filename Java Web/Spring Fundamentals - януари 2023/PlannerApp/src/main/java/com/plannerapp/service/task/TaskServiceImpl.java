package com.plannerapp.service.task;

import com.plannerapp.model.dto.AddTaskDTO;
import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.service.priority.PriorityService;
import com.plannerapp.service.user.UserService;
import com.plannerapp.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    private final LoggedUser loggedUser;

    private final UserService userService;

    private final PriorityService priorityService;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, LoggedUser loggedUser, UserService userService, PriorityService priorityService) {
        this.taskRepository = taskRepository;
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.priorityService = priorityService;
    }

    @Override
    public void addTask(AddTaskDTO addTaskDTO) {
        TaskEntity task = new TaskEntity();

        task.setDescription(addTaskDTO.getDescription());

        task.setDueDate(LocalDate.parse(addTaskDTO.getDueDate()));

        task.setPriority(this.priorityService.findByPriority(addTaskDTO.getPriority()));

        this.taskRepository.save(task);
    }

    @Override
    public Set<TaskEntity> findAllAvailableTasks() {
        return new HashSet<>(this.taskRepository.findByUserNull());
    }

    @Override
    public void assignTask(Long id) {
        TaskEntity task = this.taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task with this ID was not found!"));

        UserEntity user = this.userService.findByUsername(this.loggedUser.getUsername());

        task.setUser(user);
    }

    @Override
    public void removeTask(Long id) {
        TaskEntity task = this.taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task with this ID was not found!"));

        task.setUser(null);

        this.taskRepository.deleteById(id);
    }

    @Override
    public void returnTask(Long id) {
        TaskEntity task = this.taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task with this ID was not found!"));

        task.setUser(null);
    }
}
