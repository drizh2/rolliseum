package com.drizh2.rolliseum.dto;

import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.Feature;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class SubclassDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private List<Feature> subclassFeatures;
    @NotNull
    private Class clas;
}
