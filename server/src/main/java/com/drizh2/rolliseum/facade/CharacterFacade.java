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
        characterDTO.setSubclass(character.getSubclass());
        characterDTO.setLevel(character.getLevel());
        characterDTO.setBackground(character.getBackground());
        characterDTO.setAlignment(character.getAlignment());
        characterDTO.setPlayerName(character.getPlayerName());

        characterDTO.setStrengthStat(character.getStrengthStat());
        characterDTO.setDexterityStat(character.getDexterityStat());
        characterDTO.setConstitutionStat(character.getConstitutionStat());
        characterDTO.setIntelligenceStat(character.getIntelligenceStat());
        characterDTO.setWisdomStat(character.getWisdomStat());
        characterDTO.setCharismaStat(character.getCharismaStat());

        characterDTO.setArmorClass(character.getArmorClass());
        characterDTO.setTotalHitDice(character.getTotalHitDice());

        characterDTO.setWeapons(character.getWeapons());

        characterDTO.setPersonaltyTraits(character.getPersonaltyTraits());
        characterDTO.setIdeals(character.getIdeals());
        characterDTO.setBonds(character.getBonds());
        characterDTO.setFlaws(character.getFlaws());

        characterDTO.setAge(character.getAge());
        characterDTO.setEyes(character.getEyes());
        characterDTO.setHeight(character.getHeight());
        characterDTO.setSkin(character.getSkin());
        characterDTO.setWeight(character.getWeight());
        characterDTO.setHair(character.getHair());
        characterDTO.setAppearance(character.getAppearance());
        characterDTO.setBackstory(character.getBackstory());

        return characterDTO;
    }
}
