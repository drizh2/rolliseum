package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.CharacterDTO;
import com.drizh2.rolliseum.entity.Character;
import org.springframework.stereotype.Component;

@Component
public class CharacterFacade {
    public CharacterDTO characterToCharacterDTO(Character character) {
        CharacterDTO characterDTO = new CharacterDTO();

        characterDTO.setName(character.getName());
        characterDTO.setClas(character.getClas());
        characterDTO.setRace(character.getRace());

        return characterDTO;
    }
}
