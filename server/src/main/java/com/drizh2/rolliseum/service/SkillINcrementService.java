package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.SkillIncrementDTO;
import com.drizh2.rolliseum.entity.SkillIncrement;
import com.drizh2.rolliseum.repository.SkillIncrementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillINcrementService {

    public static final Logger LOG = LoggerFactory.getLogger(SkillINcrementService.class);

    private final SkillIncrementRepository skillIncrementRepository;

    @Autowired
    public SkillINcrementService(SkillIncrementRepository skillIncrementRepository) {
        this.skillIncrementRepository = skillIncrementRepository;
    }

    public SkillIncrement createSkillIncrement(SkillIncrementDTO skillIncrementDTO) {
        SkillIncrement skillIncrement = new SkillIncrement();

        skillIncrement.setName(skillIncrementDTO.getName());
        skillIncrement.setModificator(skillIncrement.getModificator());

        LOG.info("Creating {} modificator with {} value", skillIncrement.getName(), skillIncrement.getModificator());

        return skillIncrementRepository.save(skillIncrement);
    }

}
