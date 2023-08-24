package com.drizh2.rolliseum.entity;

import com.drizh2.rolliseum.entity.enums.Classes;

import java.util.List;

public class Class {
    private Classes name;
    private int hitDice;
    private int firstLevelHits;
    private int nextLevelHits;
    private Subclass subclass;
    private List<Feature> features;
    private List<String> armor;
    private List<String> weapons;
    private List<String> tools;
    private List<String> savingThrows;
    private List<String> stats;
    private int spellSavingThrow;
}
