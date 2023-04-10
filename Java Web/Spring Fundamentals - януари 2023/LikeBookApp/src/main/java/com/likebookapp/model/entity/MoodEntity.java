package com.likebookapp.model.entity;

import com.likebookapp.model.enums.MoodEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "moods")
public class MoodEntity extends BaseEntity {
    @Column(name = "description")
    private String description;

    @NotNull(message = "Mood field cannot be null!")
    @Enumerated(EnumType.STRING)
    @Column(name = "mood", nullable = false, unique = true)
    private MoodEnum mood;
}