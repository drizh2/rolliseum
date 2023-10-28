package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.SkillIncrementDTO;
import com.drizh2.rolliseum.entity.SkillIncrement;
import org.springframework.stereotype.Component;

@Component
public class SkillIncrementFacade {
    public SkillIncrementDTO skillIncrementToSkillIncrementDTO(SkillIncrement skillIncrement) {
        SkillIncrementDTO skillIncrementDTO = new SkillIncrementDTO();

        skillIncrementDTO.setName(skillIncrement.getName());
        skillIncrementDTO.setModificator(skillIncrement.getModificator());

        return skillIncrementDTO;
    }
}
