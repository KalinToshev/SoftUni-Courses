package com.plannerapp.controller;

import com.plannerapp.model.dto.AddTaskDTO;
import com.plannerapp.service.task.TaskService;
import com.plannerapp.service.user.UserService;
import com.plannerapp.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
public class TaskController {
    private final TaskService taskService;

    private final LoggedUser loggedUser;

    @Autowired
    public TaskController(TaskService taskService, LoggedUser loggedUser) {
        this.taskService = taskService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/task/add")
    private String getTaskAdd() {
        if (!this.loggedUser.isLogged()) {
            return "redirect:/";
        }

        return "task-add";
    }

    @PostMapping("/task/add")
    public String addTask(@Valid AddTaskDTO addTaskDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("addTaskDTO", addTaskDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addTaskDTO", bindingResult);

            return "redirect:/task/add";
        }

        this.taskService.addTask(addTaskDTO);

        return "redirect:/home";
    }

    @ModelAttribute
    private AddTaskDTO addTaskDTO() {
        return new AddTaskDTO();
    }
}
