package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.SkillIncrementDTO;
import com.drizh2.rolliseum.entity.SkillIncrement;

public class SkillIncrementFacade {

    private SkillIncrementFacade() {}

    public static SkillIncrementDTO skillIncrementToSkillIncrementDTO(SkillIncrement skillIncrement) {
        return SkillIncrementDTO.builder()
                .name(skillIncrement.getName())
                .modificator(skillIncrement.getModificator())
                .build();
    }

    public static SkillIncrement skillIncrementDTOToSkillIncrement(SkillIncrementDTO skillIncrementDTO) {
        return SkillIncrement.builder()
                .name(skillIncrementDTO.getName())
                .modificator(skillIncrementDTO.getModificator())
                .build();
    }
}
