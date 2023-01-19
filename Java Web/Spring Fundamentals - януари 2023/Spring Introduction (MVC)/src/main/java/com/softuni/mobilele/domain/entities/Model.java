package com.softuni.mobilele.domain.entities;

import com.softuni.mobilele.domain.enums.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "models")
@Getter
@Setter
@NoArgsConstructor
public class Model extends BaseEntity {

    @Column(nullable = false)
    private String name; //a model name.

    @Enumerated(EnumType.STRING)
    @NotNull
    private Category category; //an enumeration (Car, Buss, Truck, Motorcycle)

    @Column(name = "image_url", nullable = false)
    @Size(min = 8, max = 512)
    private String imageUrl; //the url of image with size between 8 and 512 characters.

    @Column(nullable = false)
    private Integer startYear; //a number.

    @Column
    private Integer endYear; //a number.

    @Column(nullable = false)
    private LocalDateTime created; //a date and time.

    @Column
    private LocalDateTime modified; //a date and time.

    @ManyToOne
    private Brand brand; //a model brand.

}
