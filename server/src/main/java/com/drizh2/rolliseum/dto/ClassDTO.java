package com.drizh2.rolliseum.dto;

import com.drizh2.rolliseum.entity.Feature;
import com.drizh2.rolliseum.entity.Subclass;
import com.drizh2.rolliseum.entity.enums.Classes;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
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
    private List<Subclass> subclasses;
    @NotNull
    private List<Feature> features;
    @NotNull
    private List<String> armor;
    @NotNull
    private List<String> weapons;
    @NotNull
    private List<String> tools;
    @NotNull
    private List<String> savingThrows;
    @NotNull
    private List<String> stats;
    @NotNull
    private int spellSavingThrow;
}
