package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "priorities")
public class PriorityEntity extends BaseEntity {
    @NotBlank(message = "Description field cannot be blank!")
    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", nullable = false, unique = true)
    private PriorityEnum priority;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "priority", cascade = CascadeType.MERGE, orphanRemoval = true)
    private Set<TaskEntity> tasks = new LinkedHashSet<>();
}