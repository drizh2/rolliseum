package com.drizh2.rolliseum.dto;

import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.Race;
import com.drizh2.rolliseum.entity.enums.Components;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
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
    private List<Class> classes;
    private List<Race> races;
}
