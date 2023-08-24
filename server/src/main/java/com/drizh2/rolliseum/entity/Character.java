package com.drizh2.rolliseum.entity;

import java.util.List;

public class Character {

    private Long id;
    private String name;
    private Class aClass;
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
    private int currentHitPoints;
    private int temporaryHitPoints;

    private int totalHitDice;

    private List<Weapon> weapons;

    private String personaltyTraits;
    private String ideals;
    private String bonds;
    private String flaws;

    private List<Spell> spells;

    private int age;
    private String eyes;
    private int height;
    private String skin;
    private int Weight;
    private String hair;
    private String appearance;
    private String backstory;
    private List<String> treasures;
}
