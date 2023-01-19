package com.softuni.mobilele.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String username; //username of the user.

    @Column(nullable = false)
    private String password; //password of the user.

    @Column(name = "first_name", nullable = false)
    private String firstName; // first name of the user.

    @Column(name = "last_name", nullable = false)
    private String lastName; // last name of the user.

    @Column(name = "is_active")
    private boolean isActive; //true OR false.

    @OneToOne
    private UserRole role; // user's role (User or Admin).

    @Column(name = "image_url")
    private String imageUrl; //a url of user's picture.

    @Column(nullable = false)
    private LocalDateTime created; //a date and time.

    @Column
    private LocalDateTime modified; //a date and time.

}
