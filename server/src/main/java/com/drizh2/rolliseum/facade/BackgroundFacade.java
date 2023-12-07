package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.BackgroundDTO;
import com.drizh2.rolliseum.entity.Background;

public class BackgroundFacade {

    private BackgroundFacade() {}

    public static BackgroundDTO backgroundToDTO(Background background) {
        return BackgroundDTO.builder()
                .name(background.getName())
                .stats(background.getStats())
                .languages(background.getLanguages())
                .equip(background.getEquip())
                .skills(background.getSkills())
                .caption(background.getCaption())
                .build();
    }

    public static Background DTOToBackground(BackgroundDTO backgroundDTO) {
        return Background.builder()
                .name(backgroundDTO.getName())
                .stats(backgroundDTO.getStats())
                .languages(backgroundDTO.getLanguages())
                .equip(backgroundDTO.getEquip())
                .skills(backgroundDTO.getSkills())
                .caption(backgroundDTO.getCaption())
                .build();
    }
}
