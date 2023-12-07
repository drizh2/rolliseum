package com.drizh2.rolliseum.dto;

import com.drizh2.rolliseum.entity.enums.Races;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RaceDTO {
    private Long id;
    @NotNull
    private Races name;
    @NotNull
    private String type;
    @NotNull
    private List<SkillIncrementDTO> stats;
    private String size;
    @NotNull
    private int speed;
    @NotNull
    private List<FeatureDTO> raceFeatures;
    @NotNull
    private List<String> languages;
}
