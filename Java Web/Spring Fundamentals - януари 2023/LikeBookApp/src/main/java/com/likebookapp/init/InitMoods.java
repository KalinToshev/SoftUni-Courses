package com.likebookapp.init;

import com.likebookapp.service.mood.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitMoods implements CommandLineRunner {
    private final MoodService moodService;

    @Autowired
    public InitMoods(MoodService moodService) {
        this.moodService = moodService;
    }

    @Override
    public void run(String... args) throws Exception {
        moodService.initMoods();
    }
}
