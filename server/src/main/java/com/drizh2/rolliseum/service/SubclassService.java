package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.FeatureDTO;
import com.drizh2.rolliseum.dto.SubclassDTO;
import com.drizh2.rolliseum.entity.Feature;
import com.drizh2.rolliseum.entity.Subclass;
import com.drizh2.rolliseum.facade.FeatureFacade;
import com.drizh2.rolliseum.facade.SubclassFacade;
import com.drizh2.rolliseum.repository.SubclassRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubclassService {

    public static final Logger LOG = LoggerFactory.getLogger(SubclassService.class);

    private final SubclassRepository subclassRepository;
    private final FeatureService featureService;

    @Autowired
    public SubclassService(SubclassRepository subclassRepository, FeatureService featureService) {
        this.subclassRepository = subclassRepository;
        this.featureService = featureService;
    }

    public Subclass createSubclass(SubclassDTO subclassDTO) {
        Subclass subclass = SubclassFacade.subclassDTOToSubclass(subclassDTO);

        subclass = subclassRepository.save(subclass);

        for (FeatureDTO featureDTO : subclassDTO.getSubclassFeatures()) {
            Feature feature = FeatureFacade.featureDTOToFeature(featureDTO);
            feature.setSubclass(subclass);
            Feature tempFeature = featureService.createFeatureForSubclass(FeatureFacade.featureToDTO(feature));
            subclass.getSubclassFeatures().add(tempFeature);
        }

        LOG.info("Subclass {} is creating", subclass.getName());

        return subclassRepository.save(subclass);
    }
}
