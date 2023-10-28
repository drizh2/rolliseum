package com.drizh2.rolliseum.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Map;

@Data
public class StatisticDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private int modificator;
    @NotNull
    private boolean savingThrow;
    @NotNull
    private Map<String, Boolean> skills;
}
