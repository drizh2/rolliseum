package com.drizh2.rolliseum.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FeatureDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String content;
    private ClassDTO clas;
    private int classLevel;
    private RaceDTO race;
    private SubclassDTO subclass;
    private int subclassLevel;
}
