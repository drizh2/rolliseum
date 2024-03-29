package com.drizh2.rolliseum.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SubclassDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private List<FeatureDTO> subclassFeatures;
    private ClassDTO clas;
}
