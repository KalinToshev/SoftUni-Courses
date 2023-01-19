package com.softuni.mobilele.domain.entities;

import com.softuni.mobilele.domain.enums.Engine;
import com.softuni.mobilele.domain.enums.Transmission;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;

@Entity
@Table(name = "offers")
@Getter
@Setter
@NoArgsConstructor
public class Offer extends BaseEntity {

    @Column
    private String description; //some text.

    @Enumerated(EnumType.STRING)
    @NotNull
    private Engine engine; //enumerated value (GASOLINE, DIESEL, ELECTRIC, HYBRID).

    @Column
    private String imageUrl; //the url of image.

    @Column(nullable = false)
    private Double mileage; //a number.

    @Column(nullable = false)
    private BigDecimal price; //the price of the offer.

    @Enumerated(EnumType.STRING)
    @NotNull
    private Transmission transmission; //enumerated value (MANUAL, AUTOMATIC).

    @Column(nullable = false)
    private Year year; //the year of offered car.

    @Column(nullable = false)
    private LocalDateTime created; //a date and time.

    @Column
    private LocalDateTime modified; //a date and time.

    @ManyToOne
    private Model model; //the model of a car.

    @ManyToOne
    private User seller; //a user that sells the car.

}
