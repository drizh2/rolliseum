package com.drizh2.rolliseum.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ToolDTO {
    private Long id;
    private String name;
    private List<ToolFeatureDTO> toolFeatures;
    private int cost;
}
