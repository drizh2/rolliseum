package com.drizh2.rolliseum.dto;

import com.drizh2.rolliseum.entity.enums.Components;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SpellDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String time;
    @NotNull
    private String distance;
    @NotNull
    private String duration;
    @NotNull
    private List<Components> components;
    @NotNull
    private String caption;
    private List<ClassDTO> classes;
    private List<RaceDTO> races;
}
