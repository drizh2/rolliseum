package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.ClassDTO;
import com.drizh2.rolliseum.dto.FeatureDTO;
import com.drizh2.rolliseum.dto.RaceDTO;
import com.drizh2.rolliseum.dto.SubclassDTO;
import com.drizh2.rolliseum.entity.Feature;

import java.util.Objects;

public class FeatureFacade {

    private FeatureFacade() {}

    public static FeatureDTO featureToDTO(Feature feature) {

        FeatureDTO featureDTO = FeatureDTO.builder()
                .name(feature.getName())
                .content(feature.getContent())
                .classLevel(feature.getClassLevel())
                .subclassLevel(feature.getSubclassLevel())
                .build();

        if (Objects.nonNull(feature.getClas())) {
            ClassDTO classDTO = ClassFacade.classToClassDTO(feature.getClas());
            featureDTO.setClas(classDTO);
        }

        if (Objects.nonNull(feature.getRace())) {
            RaceDTO raceDTO = RaceFacade.raceToRaceDTO(feature.getRace());
            featureDTO.setRace(raceDTO);
        }

        if (Objects.nonNull(feature.getSubclass())) {
            SubclassDTO subclassDTO = SubclassFacade.subclassToDTO(feature.getSubclass());
            featureDTO.setSubclass(subclassDTO);
        }

        return featureDTO;
    }

    public static Feature featureDTOToFeature(FeatureDTO featureDTO) {

        return Feature.builder()
                .name(featureDTO.getName())
                .content(featureDTO.getContent())
                .classLevel(featureDTO.getClassLevel())
                .subclassLevel(featureDTO.getSubclassLevel())
                .build();
    }

    public static FeatureDTO getRequestMapper(Feature feature) {

        return FeatureDTO.builder()
                .name(feature.getName())
                .content(feature.getContent())
                .classLevel(feature.getClassLevel())
                .subclassLevel(feature.getSubclassLevel())
                .build();
    }
}
