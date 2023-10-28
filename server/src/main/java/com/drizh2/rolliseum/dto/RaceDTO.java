package com.drizh2.rolliseum.dto;

import com.drizh2.rolliseum.entity.Feature;
import com.drizh2.rolliseum.entity.SkillIncrement;
import com.drizh2.rolliseum.entity.enums.Races;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class RaceDTO {
    private Long id;
    @NotNull
    private Races name;
    @NotNull
    private String type;
    @NotNull
    private List<SkillIncrement> stats;
    private String size;
    @NotNull
    private int speed;
    @NotNull
    private List<Feature> raceFeatures;
    @NotNull
    private List<String> languages;
}
