package com.plannerapp.service.priority;

import com.plannerapp.model.entity.PriorityEntity;
import com.plannerapp.model.enums.PriorityEnum;
import com.plannerapp.repo.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PriorityServiceImpl implements PriorityService {
    private final PriorityRepository priorityRepository;

    @Autowired
    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void initPriorities() {
        if (this.priorityRepository.count() == 0) {
            Arrays.stream(PriorityEnum.values())
                    .forEach(priorityEnum -> {
                        PriorityEntity priority = new PriorityEntity();

                        priority.setPriority(priorityEnum);

                        switch (priorityEnum.name()) {
                            case "URGENT":
                                priority.setDescription("An urgent problem that blocks the system use until the issue is resolved.");
                                break;
                            case "IMPORTANT":
                                priority.setDescription("A core functionality that your product is explicitly supposed to perform is compromised.");
                                break;
                            case "LOW":
                                priority.setDescription("Should be fixed if time permits but can be postponed.");
                                break;
                        }

                        this.priorityRepository.save(priority);
            });
        }
    }

    @Override
    public PriorityEntity findByPriority(PriorityEnum priority) {
        return priorityRepository.findByPriority(priority).orElseThrow(() -> new IllegalArgumentException("Priority Entity with this priority was not found!"));
    }
}
