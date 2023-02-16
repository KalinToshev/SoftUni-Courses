package com.softuni.mobilele.domain.entities;

import com.softuni.mobilele.domain.enums.Category;
import jakarta.persistence.*;
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

    @Column
    private String name; // – a model name.

    @Enumerated(EnumType.STRING)
    private Category category; // – an enumeration (Car, Buss, Truck, Motorcycle)

    @Column(name = "image_url")
    private String imageUrl; // – the url of image with size between 8 and 512 characters.

    @Column(name = "start_year")
    private Integer startYear; // – a number.

    @Column(name = "end_year")
    private Integer endYear; // – a number.

    @Column
    private LocalDateTime created; // – a date and time.

    @Column
    private LocalDateTime modified; // – a date and time.

    @ManyToOne
    private Brand brand; // – a model brand.


}
