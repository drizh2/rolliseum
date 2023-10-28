package com.drizh2.rolliseum.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WeaponDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String type;
    @NotNull
    private String range;
    @NotNull
    private int attackBonus;
    @NotNull
    private int damage;
    @NotNull
    private String damageType;
}
