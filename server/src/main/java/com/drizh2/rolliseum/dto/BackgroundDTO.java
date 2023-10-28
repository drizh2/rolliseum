package com.drizh2.rolliseum.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class BackgroundDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private List<String> stats;
    @NotNull
    private List<String> languages;
    @NotNull
    private List<String> equip;
    @NotNull
    private List<String> skills;
    @NotNull
    private String caption;
}
