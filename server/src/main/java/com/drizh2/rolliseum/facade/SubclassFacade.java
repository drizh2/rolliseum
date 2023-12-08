package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.ClassDTO;
import com.drizh2.rolliseum.dto.FeatureDTO;
import com.drizh2.rolliseum.dto.SubclassDTO;
import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.Subclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubclassFacade {

    private SubclassFacade() {}

    public static SubclassDTO subclassToDTO(Subclass subclass){
        List<FeatureDTO> featureDTOList = subclass.getSubclassFeatures().stream()
                .map(FeatureFacade::featureToDTO)
                .toList();

        ClassDTO classDTO = ClassFacade.classToClassDTO(subclass.getClas());

        return SubclassDTO.builder()
                .id(subclass.getId())
                .name(subclass.getName())
                .subclassFeatures(featureDTOList)
                .clas(classDTO)
                .build();
    }

    public static Subclass subclassDTOToSubclass(SubclassDTO subclassDTO) {

        Subclass subclass = Subclass.builder()
                .id(subclassDTO.getId())
                .name(subclassDTO.getName())
                .subclassFeatures(new ArrayList<>())
                .build();

        if (Objects.nonNull(subclassDTO.getClas())) {
            Class clas = ClassFacade.classDTOToClass(subclassDTO.getClas());
            subclass.setClas(clas);
        }

        return subclass;
    }

    public static SubclassDTO getRequestMapper(Subclass subclass) {
        List<FeatureDTO> featureDTOList = subclass.getSubclassFeatures().stream()
                .map(FeatureFacade::getRequestMapper)
                .toList();

        return SubclassDTO.builder()
                .id(subclass.getId())
                .name(subclass.getName())
                .subclassFeatures(featureDTOList)
                .build();
    }
}
