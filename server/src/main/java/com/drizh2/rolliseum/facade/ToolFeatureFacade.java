package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.ToolDTO;
import com.drizh2.rolliseum.dto.ToolFeatureDTO;
import com.drizh2.rolliseum.entity.Tool;
import com.drizh2.rolliseum.entity.ToolFeature;

import java.util.Objects;

public class ToolFeatureFacade {

    private ToolFeatureFacade() {}

    public static ToolFeatureDTO toolFeatureToToolFeatureDTO(ToolFeature toolFeature) {

        ToolDTO toolDTO = ToolFacade.toolToToolDTO(toolFeature.getTool());

        return ToolFeatureDTO.builder()
                .name(toolFeature.getName())
                .content(toolFeature.getContent())
                .tool(toolDTO)
                .build();
    }

    public static ToolFeature toolFeatureDTOToToolFeature(ToolFeatureDTO toolFeatureDTO) {

        ToolFeature toolFeature = ToolFeature.builder()
                .name(toolFeatureDTO.getName())
                .content(toolFeatureDTO.getContent())
                .build();

        if (Objects.nonNull(toolFeatureDTO.getTool())) {
            Tool tool = ToolFacade.toolDTOToTool(toolFeatureDTO.getTool());
            toolFeature.setTool(tool);
        }

        return toolFeature;
    }

    public static ToolFeatureDTO getRequestMqpping(ToolFeature toolFeature) {
        return ToolFeatureDTO.builder()
                .name(toolFeature.getName())
                .content(toolFeature.getContent())
                .build();
    }
}
