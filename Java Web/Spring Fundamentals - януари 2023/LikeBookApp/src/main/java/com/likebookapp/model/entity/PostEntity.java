package com.likebookapp.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "posts")
public class PostEntity extends BaseEntity {
    @Size(message = "Content field must contain from 2 to 150 characters (inclusive)!", min = 2, max = 150)
    @NotBlank(message = "Content field cannot be blank!")
    @Column(name = "content", nullable = false, length = 150)
    private String content;

    @NotNull(message = "Creator field cannot be null!")
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "creator_id", nullable = false)
    private UserEntity creator;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "post_likes", cascade = CascadeType.MERGE)
    private Set<UserEntity> likedBy = new LinkedHashSet<>();

    @NotNull(message = "Mood field cannot be null!")
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "mood_id", nullable = false)
    private MoodEntity mood;
}