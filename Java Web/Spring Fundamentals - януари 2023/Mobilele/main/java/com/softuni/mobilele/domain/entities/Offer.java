package com.softuni.mobilele.domain.entities;

import com.softuni.mobilele.domain.enums.Engine;
import com.softuni.mobilele.domain.enums.Transmission;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.Banner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
@Getter
@Setter
@NoArgsConstructor
public class Offer extends BaseEntity {
    @Column
    private String description; // – some text.

    @Enumerated(EnumType.STRING)
    private Engine engine; // – enumerated value (GASOLINE, DIESEL, ELECTRIC, HYBRID).

    @Column(name = "image_url")
    private String imageUrl; // – the url of image.

    @Column
    private Integer mileage; // – a number.

    @Column
    private BigDecimal price; // – the price of the offer.

    @Enumerated(EnumType.STRING)
    private Transmission transmission; // – enumerated value (MANUAL, AUTOMATIC).

    @Column
    private Integer year; // – the year of offered car.

    @Column
    private LocalDateTime created; // – a date and time.

    @Column
    private LocalDateTime modified; // – a date and time.

    @ManyToOne
    private Model model; // – the model of a car.

    @OneToOne
    private User seller; // – a user that sells the car.
}
