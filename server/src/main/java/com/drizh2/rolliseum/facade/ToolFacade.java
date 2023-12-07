package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.ToolDTO;
import com.drizh2.rolliseum.dto.ToolFeatureDTO;
import com.drizh2.rolliseum.entity.Tool;
import com.drizh2.rolliseum.entity.ToolFeature;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class ToolFacade {

    private ToolFacade() {}

    public static ToolDTO toolToToolDTO(Tool tool) {
//        List<ToolFeatureDTO> featureDTOList = tool.getToolFeatures().stream()
//                .map(ToolFeatureFacade::toolFeatureToToolFeatureDTO)
//                .toList();

        return ToolDTO.builder()
                .id(tool.getId())
                .toolFeatures(new ArrayList<>())
                .cost(tool.getCost())
                .build();
    }

    public static Tool toolDTOToTool(ToolDTO toolDTO) {
        return Tool.builder()
                .id(toolDTO.getId())
                .name(toolDTO.getName())
                .cost(toolDTO.getCost())
                .toolFeatures(new ArrayList<>())
                .build();
    }
}
