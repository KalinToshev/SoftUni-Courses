package com.plannerapp.controller;

import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.service.task.TaskService;
import com.plannerapp.service.user.UserService;
import com.plannerapp.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class HomeController {
    private final LoggedUser loggedUser;

    private final TaskService taskService;

    private final UserService userService;

    @Autowired
    public HomeController(LoggedUser loggedUser, TaskService taskService, UserService userService) {
        this.loggedUser = loggedUser;
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        if (this.loggedUser.isLogged()) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (!this.loggedUser.isLogged()) {
            return "redirect:/";
        }

        Set<TaskEntity> allAvailableTasks = this.taskService.findAllAvailableTasks();

        model.addAttribute("allAvailableTasks", allAvailableTasks);

        Set<TaskEntity> allUserAssignedTasks = this.userService.findByUsername(this.loggedUser.getUsername()).getAssignedTasks();

        model.addAttribute("allUserAssignedTasks", allUserAssignedTasks);

        return "home";
    }
}
