package com.plannerapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class TaskEntity extends BaseEntity {
    @Size(message = "Description field must contain from 2 to 50 characters (inclusive)!", min = 2, max = 50)
    @NotBlank(message = "Description field cannot be blank!")
    @Column(name = "description", nullable = false, length = 50)
    private String description;

    @Future(message = "Date field should be in the future!")
    @NotNull(message = "Date field cannot be null!")
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @NotNull(message = "Priority field cannot be null!")
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "priority_id", nullable = false)
    private PriorityEntity priority;

}