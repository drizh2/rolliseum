package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.ClassDTO;
import com.drizh2.rolliseum.dto.FeatureDTO;
import com.drizh2.rolliseum.dto.SubclassDTO;
import com.drizh2.rolliseum.dto.ToolDTO;
import com.drizh2.rolliseum.entity.Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassFacade {

    private ClassFacade() {}

    public static ClassDTO classToClassDTO(Class clas) {

        List<ToolDTO> toolDTOList = clas.getTools().stream()
                .map(ToolFacade::toolToToolDTO)
                .toList();

        ClassDTO classDTO = ClassDTO.builder()
                .id(clas.getId())
                .name(clas.getName())
                .hitDice(clas.getHitDice())
                .firstLevelHits(clas.getFirstLevelHits())
                .nextLevelHits(clas.getNextLevelHits())
                .armor(clas.getArmor())
                .weapons(clas.getWeapons())
                .tools(toolDTOList)
                .savingThrows(clas.getSavingThrows())
                .skills(clas.getSkills())
                .spellSavingThrow(clas.getSpellSavingThrow())
                .build();

        if (Objects.nonNull(clas.getSubclasses())) {
            List<SubclassDTO> subclassDTOList = clas.getSubclasses().stream()
                    .map(SubclassFacade::subclassToDTO)
                    .toList();

            classDTO.setSubclasses(subclassDTOList);
        }

        if (Objects.nonNull(clas.getFeatures())) {
            List<FeatureDTO> featureDTOList = clas.getFeatures().stream()
                    .map(FeatureFacade::featureToDTO)
                    .toList();

            classDTO.setFeatures(featureDTOList);
        }

        return classDTO;
    }

    public static Class classDTOToClass(ClassDTO classDTO) {

        return Class.builder()
                .id(classDTO.getId())
                .name(classDTO.getName())
                .hitDice(classDTO.getHitDice())
                .firstLevelHits(classDTO.getFirstLevelHits())
                .nextLevelHits(classDTO.getNextLevelHits())
                .armor(classDTO.getArmor())
                .weapons(classDTO.getWeapons())
                .tools(new ArrayList<>())
                .features(new ArrayList<>())
                .savingThrows(classDTO.getSavingThrows())
                .skills(classDTO.getSkills())
                .spellSavingThrow(classDTO.getSpellSavingThrow())
                .subclasses(new ArrayList<>())
                .build();
    }

    public static ClassDTO getRequestMapping(Class clas) {
        List<ToolDTO> toolDTOList = clas.getTools().stream()
                .map(ToolFacade::getRequestMapping)
                .toList();

        ClassDTO classDTO = ClassDTO.builder()
                .id(clas.getId())
                .name(clas.getName())
                .hitDice(clas.getHitDice())
                .firstLevelHits(clas.getFirstLevelHits())
                .nextLevelHits(clas.getNextLevelHits())
                .armor(clas.getArmor())
                .weapons(clas.getWeapons())
                .tools(toolDTOList)
                .savingThrows(clas.getSavingThrows())
                .skills(clas.getSkills())
                .spellSavingThrow(clas.getSpellSavingThrow())
                .build();

        if (Objects.nonNull(clas.getSubclasses())) {
            List<SubclassDTO> subclassDTOList = clas.getSubclasses().stream()
                    .map(SubclassFacade::getRequestMapper)
                    .toList();

            classDTO.setSubclasses(subclassDTOList);
        }

        if (Objects.nonNull(clas.getFeatures())) {
            List<FeatureDTO> featureDTOList = clas.getFeatures().stream()
                    .map(FeatureFacade::getRequestMapper)
                    .toList();

            classDTO.setFeatures(featureDTOList);
        }

        return classDTO;
    }
}
