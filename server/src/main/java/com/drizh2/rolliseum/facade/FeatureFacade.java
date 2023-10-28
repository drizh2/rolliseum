package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.FeatureDTO;
import com.drizh2.rolliseum.entity.Feature;
import org.springframework.stereotype.Component;

@Component
public class FeatureFacade {
    public FeatureDTO featureToDTO(Feature feature) {
        FeatureDTO featureDTO = new FeatureDTO();

        featureDTO.setName(feature.getName());
        featureDTO.setContent(feature.getContent());
        featureDTO.setClas(feature.getClas());
        featureDTO.setClassLevel(feature.getClassLevel());
        featureDTO.setRace(feature.getRace());
        featureDTO.setSubclass(feature.getSubclass());
        featureDTO.setSubclassLevel(feature.getSubclassLevel());

        return featureDTO;
    }
}
