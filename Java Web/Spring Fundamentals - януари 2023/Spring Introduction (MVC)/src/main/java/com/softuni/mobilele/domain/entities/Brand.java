package com.softuni.mobilele.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "brands")
@NoArgsConstructor
@Getter
@Setter
public class Brand extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;  //a name of brand.

    @Column(nullable = false)
    private LocalDateTime created;  //a date and time.

    @Column
    private LocalDateTime modified;  //a date and time.

}
