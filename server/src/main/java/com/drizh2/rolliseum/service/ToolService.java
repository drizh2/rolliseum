package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.ToolDTO;
import com.drizh2.rolliseum.dto.ToolFeatureDTO;
import com.drizh2.rolliseum.entity.Tool;
import com.drizh2.rolliseum.entity.ToolFeature;
import com.drizh2.rolliseum.facade.ToolFacade;
import com.drizh2.rolliseum.facade.ToolFeatureFacade;
import com.drizh2.rolliseum.repository.ToolRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolService {

    public static final Logger LOG = LoggerFactory.getLogger(ToolService.class);

    private final ToolRepository toolRepository;
    private final ToolFeatureService toolFeatureService;

    @Autowired
    public ToolService(ToolRepository toolRepository, ToolFeatureService toolFeatureService) {
        this.toolRepository = toolRepository;
        this.toolFeatureService = toolFeatureService;
    }

    public Tool createTool(ToolDTO toolDTO) {
        Tool tool = ToolFacade.toolDTOToTool(toolDTO);

        tool = toolRepository.save(tool);
        for (ToolFeatureDTO toolFeatureDTO : toolDTO.getToolFeatures()) {
            ToolFeature toolFeature = ToolFeatureFacade.toolFeatureDTOToToolFeature(toolFeatureDTO);
            toolFeature.setTool(tool);
            ToolFeature tempToolFeature = toolFeatureService.createToolFeature(ToolFeatureFacade.toolFeatureToToolFeatureDTO(toolFeature));
            tool.getToolFeatures().add(tempToolFeature);
        }

        return toolRepository.save(tool);
    }
}