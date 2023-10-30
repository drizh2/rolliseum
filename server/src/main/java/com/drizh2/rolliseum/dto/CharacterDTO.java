package com.drizh2.rolliseum.dto;

import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CharacterDTO {
    private Long id;
    @NotNull
    private String name;
//    @NotNull
    private Class clas;
//    @NotNull
    private Subclass subclass;
    private Race race;
    private int level;
    private Background background;
    private String alignment;
    private String playerName;

    private Statistic strengthStat;
    private Statistic dexterityStat;
    private Statistic constitutionStat;
    private Statistic intelligenceStat;
    private Statistic wisdomStat;
    private Statistic charismaStat;

    private int armorClass;
    private int totalHitDice;

    private List<Weapon> weapons;

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
