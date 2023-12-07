package com.drizh2.rolliseum.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CharacterDTO {
    private Long id;
    @NotNull
    private String name;
    private ClassDTO clas;
    private SubclassDTO subclass;
    private RaceDTO race;
    private int level;
    private BackgroundDTO background;
    private String alignment;
    private String playerName;

    private StatisticDTO strengthStat;
    private StatisticDTO dexterityStat;
    private StatisticDTO constitutionStat;
    private StatisticDTO intelligenceStat;
    private StatisticDTO wisdomStat;
    private StatisticDTO charismaStat;

    private int armorClass;
    private int totalHitDice;

    private List<WeaponDTO> weapons;

    private String personaltyTraits;
    private String ideals;
    private String bonds;
    private String flaws;

    private int age;
    private String eyes;
    private int height;
    private String skin;
    private int weight;
    private String hair;
    private String appearance;
    private String backstory;
}
