package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.BackgroundDTO;
import com.drizh2.rolliseum.entity.Background;
import org.springframework.stereotype.Component;

@Component
public class BackgroundFacade {
    public BackgroundDTO backgroundToDTO(Background background) {
        BackgroundDTO backgroundDTO = new BackgroundDTO();

        backgroundDTO.setName(background.getName());
        backgroundDTO.setStats(background.getStats());
        backgroundDTO.setLanguages(background.getLanguages());
        backgroundDTO.setEquip(background.getEquip());
        backgroundDTO.setSkills(background.getSkills());
        backgroundDTO.setCaption(background.getCaption());

        return backgroundDTO;
    }
}
