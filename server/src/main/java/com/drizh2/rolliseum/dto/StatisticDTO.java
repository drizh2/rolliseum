package com.drizh2.rolliseum.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
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
