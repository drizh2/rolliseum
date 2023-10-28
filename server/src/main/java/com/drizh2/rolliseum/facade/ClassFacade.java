package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.ClassDTO;
import com.drizh2.rolliseum.entity.Class;
import org.springframework.stereotype.Component;

@Component
public class ClassFacade {
    public ClassDTO classToClassDTO(Class clas) {
        ClassDTO classDTO = new ClassDTO();

        classDTO.setName(clas.getName());
        classDTO.setHitDice(clas.getHitDice());
        classDTO.setFirstLevelHits(clas.getFirstLevelHits());
        classDTO.setNextLevelHits(clas.getNextLevelHits());
        classDTO.setSubclasses(clas.getSubclasses());
        classDTO.setFeatures(clas.getFeatures());
        classDTO.setArmor(clas.getArmor());
        classDTO.setWeapons(clas.getWeapons());
        classDTO.setTools(clas.getTools());
        classDTO.setSavingThrows(clas.getSavingThrows());
        classDTO.setStats(clas.getStats());
        classDTO.setSpellSavingThrow(clas.getSpellSavingThrow());

        return classDTO;
    }
}
