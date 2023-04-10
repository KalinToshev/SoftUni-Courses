package com.likebookapp.model.dto;

import com.likebookapp.model.entity.MoodEntity;
import com.likebookapp.model.enums.MoodEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddPostDTO {
    @Size(message = "Content field must contain from 2 to 150 characters (inclusive)!", min = 2, max = 150)
    @NotBlank(message = "Content field cannot be blank!")
    private String content;

    @NotNull(message = "Mood field cannot be null!")
    private MoodEnum mood;
}
