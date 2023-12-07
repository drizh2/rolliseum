package com.drizh2.rolliseum.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ToolFeatureDTO {
    private Long id;
    private String name;
    private String content;
    private ToolDTO tool;
}
