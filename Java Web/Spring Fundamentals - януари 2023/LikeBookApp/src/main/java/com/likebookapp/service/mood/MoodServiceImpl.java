package com.likebookapp.service.mood;

import com.likebookapp.model.entity.MoodEntity;
import com.likebookapp.model.enums.MoodEnum;
import com.likebookapp.repository.MoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MoodServiceImpl implements MoodService {
    private final MoodRepository moodRepository;

    @Autowired
    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void initMoods() {
        if (this.moodRepository.count() == 0) {
            Arrays.stream(MoodEnum.values()).forEach(moodEnum -> {
                MoodEntity mood = new MoodEntity();

                mood.setMood(moodEnum);

                switch (moodEnum.name()) {
                    case "HAPPY":
                        mood.setDescription("Feeling joyous and content, with a positive outlook and a sense of well-being.");
                        break;
                    case "SAD":
                        mood.setDescription("Feeling down or unhappy, with a sense of sorrow or loss, and a lack of energy or motivation.");
                        break;
                    case "INSPIRED":
                        mood.setDescription("Feeling energized, creative, and motivated to pursue new ideas or projects, with a sense of excitement and possibility.");
                        break;
                }

                this.moodRepository.save(mood);
            });
        }
    }

    @Override
    public MoodEntity findMood(MoodEnum mood) {
        return moodRepository.findByMood(mood).orElseThrow(() -> new IllegalArgumentException("Mood with this name was not found!"));
    }
}
