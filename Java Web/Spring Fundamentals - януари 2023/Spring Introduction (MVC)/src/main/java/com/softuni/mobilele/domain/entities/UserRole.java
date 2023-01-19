package com.softuni.mobilele.domain.entities;

import com.softuni.mobilele.domain.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
@NoArgsConstructor
public class UserRole extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role; //enumerated value

}
