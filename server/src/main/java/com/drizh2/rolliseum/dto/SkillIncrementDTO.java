package com.drizh2.rolliseum.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SkillIncrementDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer modificator;
}
