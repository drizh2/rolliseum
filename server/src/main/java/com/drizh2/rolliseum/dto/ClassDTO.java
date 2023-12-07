package com.drizh2.rolliseum.dto;

import com.drizh2.rolliseum.entity.enums.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ClassDTO {
    private Long id;
    @NotNull
    private Classes name;
    @NotNull
    private int hitDice;
    @NotNull
    private int firstLevelHits;
    @NotNull
    private int nextLevelHits;
    @NotNull
    private List<SubclassDTO> subclasses;
    @NotNull
    private List<FeatureDTO> features;
    @NotNull
    private List<ArmorTypes> armor;
    @NotNull
    private List<WeaponTypes> weapons;
    @NotNull
    private List<ToolDTO> tools;
    @NotNull
    private List<SavingThrows> savingThrows;
    @NotNull
    private List<Skills> skills;
    @NotNull
    private int countOfStats;
    @NotNull
    private int spellSavingThrow;
}
