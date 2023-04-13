package com.plannerapp.init;

import com.plannerapp.service.priority.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitPriorities implements CommandLineRunner {
    private final PriorityService priorityService;

    @Autowired
    public InitPriorities(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.priorityService.initPriorities();
    }
}
