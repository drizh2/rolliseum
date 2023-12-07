package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.ClassDTO;
import com.drizh2.rolliseum.dto.ToolDTO;
import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.service.ToolService;

import java.util.ArrayList;
import java.util.List;

public class ClassFacade {

    private final ToolService toolService;

    private ClassFacade(ToolService toolService) {
        this.toolService = toolService;
    }

    public static ClassDTO classToClassDTO(Class clas) {

        List<ToolDTO> toolDTOList = clas.getTools().stream()
                        .map(ToolFacade::toolToToolDTO)
                        .toList();

        return ClassDTO.builder()
                .id(clas.getId())
                .name(clas.getName())
                .hitDice(clas.getHitDice())
                .firstLevelHits(clas.getFirstLevelHits())
                .nextLevelHits(clas.getNextLevelHits())
                .subclasses(new ArrayList<>())
                .features(new ArrayList<>())
                .armor(clas.getArmor())
                .weapons(clas.getWeapons())
                .tools(toolDTOList)
                .savingThrows(clas.getSavingThrows())
                .skills(clas.getSkills())
                .spellSavingThrow(clas.getSpellSavingThrow())
                .build();
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
}
