package com.drizh2.rolliseum.dto;

import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.Race;
import com.drizh2.rolliseum.entity.Subclass;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FeatureDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String content;
    private Class clas;
    private int classLevel;
    private Race race;
    private Subclass subclass;
    private int subclassLevel;
}
