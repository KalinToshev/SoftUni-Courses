package com.softuni.battleships.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllShipDTO {
    private String name;

    private Integer power;

    private Integer health;
}
