package com.drizh2.rolliseum.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SkillIncrementDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer modificator;
}
