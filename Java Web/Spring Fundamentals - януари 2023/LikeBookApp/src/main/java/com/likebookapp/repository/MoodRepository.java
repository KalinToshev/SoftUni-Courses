package com.likebookapp.repository;

import com.likebookapp.model.entity.MoodEntity;
import com.likebookapp.model.enums.MoodEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoodRepository extends JpaRepository<MoodEntity, Long> {
    Optional<MoodEntity> findByMood(MoodEnum mood);
}