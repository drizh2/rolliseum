package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.ToolFeatureDTO;
import com.drizh2.rolliseum.entity.ToolFeature;
import com.drizh2.rolliseum.facade.ToolFeatureFacade;
import com.drizh2.rolliseum.repository.ToolFeatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolFeatureService {

    public static final Logger LOG = LoggerFactory.getLogger(ToolFeatureService.class);

    private final ToolFeatureRepository toolFeatureRepository;

    @Autowired
    public ToolFeatureService(ToolFeatureRepository toolFeatureRepository) {
        this.toolFeatureRepository = toolFeatureRepository;
    }

    public ToolFeature createToolFeature(ToolFeatureDTO toolFeatureDTO) {
        ToolFeature toolFeature = ToolFeatureFacade.toolFeatureDTOToToolFeature(toolFeatureDTO);

        LOG.info("Feature {} is creating!", toolFeature.getName());

        return toolFeatureRepository.save(toolFeature);
    }
}
