package com.plannerapp.model.dto;

import com.plannerapp.model.enums.PriorityEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddTaskDTO {
    @Size(message = "Description field must contain from 2 to 50 characters (inclusive)!", min = 2, max = 50)
    @NotBlank(message = "Description field cannot be blank!")
    private String description;

    @NotBlank(message = "Date field cannot be blank!")
    private String dueDate;

    @NotNull(message = "Priority field cannot be null!")
    private PriorityEnum priority;
}
