package com.plannerapp.service.priority;

import com.plannerapp.model.entity.PriorityEntity;
import com.plannerapp.model.enums.PriorityEnum;

public interface PriorityService {
    void initPriorities();

    PriorityEntity findByPriority(PriorityEnum priority);
}
