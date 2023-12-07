package com.drizh2.rolliseum.dto;

import com.drizh2.rolliseum.entity.enums.WeaponTypes;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class WeaponDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private List<WeaponTypes> types;
    @NotNull
    private String range;
    @NotNull
    private int attackBonus;
    @NotNull
    private int damage;
    @NotNull
    private String damageType;
}
