package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.FeatureDTO;
import com.drizh2.rolliseum.entity.Feature;
import com.drizh2.rolliseum.repository.FeatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FeatureService {

    public static final Logger LOG = LoggerFactory.getLogger(FeatureService.class);

    private final FeatureRepository featureRepository;

    @Autowired
    public FeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public Feature createFeatureForClass(FeatureDTO featureDTO) {
        Feature feature = new Feature();

        feature.setName(featureDTO.getName());
        feature.setContent(featureDTO.getContent());
        feature.setClas(featureDTO.getClas());
        feature.setClassLevel(featureDTO.getClassLevel());

        LOG.info("Creating {} feature for class {}", feature.getName(), feature.getClas().getName());

        return featureRepository.save(feature);
    }

    public Feature createFeatureForRace(FeatureDTO featureDTO) {
        Feature feature = new Feature();

        feature.setName(featureDTO.getName());
        feature.setContent(featureDTO.getContent());
        feature.setRace(featureDTO.getRace());

        LOG.info("Creating {} feature for race {}", feature.getName(), feature.getRace().getName());

        return featureRepository.save(feature);
    }

    public Feature createFeatureForSubclass(FeatureDTO featureDTO) {
        Feature feature = new Feature();

        feature.setName(featureDTO.getName());
        feature.setContent(featureDTO.getContent());
        feature.setSubclass(featureDTO.getSubclass());
        feature.setSubclassLevel(featureDTO.getSubclassLevel());

        LOG.info("Creating {} feature for subclass {}", feature.getName(), feature.getSubclass().getName());

        return featureRepository.save(feature);
    }

    public Feature getFeatureById(Long id) {
        return featureRepository.findFeatureById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Feature has not been found!"));
    }
}
