package com.drizh2.rolliseum.entity;

import com.drizh2.rolliseum.entity.enums.Races;

import java.util.List;
import java.util.Map;

public class Race {
    private Races name;
    private String type;
    private List<Map<String, Integer>> stats;
    private String size;
    private int speed;
    private List<Feature> raceFeatures;
    private List<String> languages;
}
