package com.drizh2.rolliseum.dto;

import com.drizh2.rolliseum.entity.enums.Skills;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    private List<Skills> skills;
}
