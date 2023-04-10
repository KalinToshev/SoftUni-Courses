package com.likebookapp.service.mood;

import com.likebookapp.model.entity.MoodEntity;
import com.likebookapp.model.enums.MoodEnum;

public interface MoodService {
    void initMoods();

    MoodEntity findMood(MoodEnum mood);
}
