package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.*;
import com.drizh2.rolliseum.entity.Character;
import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.*;

import java.util.List;

public class CharacterFacade {

    private CharacterFacade() {}

    public static CharacterDTO characterToCharacterDTO(Character character) {
        ClassDTO classDTO = ClassFacade.classToClassDTO(character.getClas());

        RaceDTO raceDTO = RaceFacade.raceToRaceDTO(character.getRace());

        SubclassDTO subclassDTO = SubclassFacade.subclassToDTO(character.getSubclass());

        BackgroundDTO backgroundDTO = BackgroundFacade.backgroundToDTO(character.getBackground());

        StatisticDTO strengthStatisticDTO = StatisticFacade.statisticToStatisticDTO(character.getStrengthStat());
        StatisticDTO dexterityStatisticDTO = StatisticFacade.statisticToStatisticDTO(character.getDexterityStat());
        StatisticDTO constitutionStatisticDTO = StatisticFacade.statisticToStatisticDTO(character.getConstitutionStat());
        StatisticDTO intelligenceStatisticDTO = StatisticFacade.statisticToStatisticDTO(character.getIntelligenceStat());
        StatisticDTO wisdomStatisticDTO = StatisticFacade.statisticToStatisticDTO(character.getWisdomStat());
        StatisticDTO charismaStatisticDTO = StatisticFacade.statisticToStatisticDTO(character.getCharismaStat());

        List<WeaponDTO> weaponDTOList = character.getWeapons().stream()
                .map(WeaponFacade::weaponToWeaponDTO)
                .toList();

        return CharacterDTO.builder()
                .name(character.getName())
                .clas(classDTO)
                .race(raceDTO)
                .subclass(subclassDTO)
                .level(character.getLevel())
                .background(backgroundDTO)
                .alignment(character.getAlignment())
                .playerName(character.getPlayerName())
                .strengthStat(strengthStatisticDTO)
                .dexterityStat(dexterityStatisticDTO)
                .constitutionStat(constitutionStatisticDTO)
                .intelligenceStat(intelligenceStatisticDTO)
                .wisdomStat(wisdomStatisticDTO)
                .charismaStat(charismaStatisticDTO)
                .armorClass(character.getArmorClass())
                .totalHitDice(character.getTotalHitDice())
                .weapons(weaponDTOList)
                .personaltyTraits(character.getPersonaltyTraits())
                .ideals(character.getIdeals())
                .bonds(character.getBonds())
                .flaws(character.getFlaws())
                .age(character.getAge())
                .eyes(character.getEyes())
                .height(character.getHeight())
                .skin(character.getSkin())
                .weight(character.getWeight())
                .hair(character.getHair())
                .appearance(character.getAppearance())
                .backstory(character.getBackstory())
                .build();
    }

    public static Character characterDTOToCharacter(CharacterDTO characterDTO) {
        Class clas = ClassFacade.classDTOToClass(characterDTO.getClas());

        Race race = RaceFacade.raceDTOToRace(characterDTO.getRace());

        Subclass subclass = SubclassFacade.subclassDTOToSubclass(characterDTO.getSubclass());

        Background background = BackgroundFacade.DTOToBackground(characterDTO.getBackground());

        Statistic strengthStatistic = StatisticFacade.statisticDTOToStatistic(characterDTO.getStrengthStat());
        Statistic dexterityStatistic = StatisticFacade.statisticDTOToStatistic(characterDTO.getDexterityStat());
        Statistic constitutionStatistic = StatisticFacade.statisticDTOToStatistic(characterDTO.getConstitutionStat());
        Statistic intelligenceStatistic = StatisticFacade.statisticDTOToStatistic(characterDTO.getIntelligenceStat());
        Statistic wisdomStatistic = StatisticFacade.statisticDTOToStatistic(characterDTO.getWisdomStat());
        Statistic charismaStatistic = StatisticFacade.statisticDTOToStatistic(characterDTO.getCharismaStat());

        List<Weapon> weaponList = characterDTO.getWeapons().stream()
                .map(WeaponFacade::weaponDTOToWeapon)
                .toList();

        return Character.builder()
                .name(characterDTO.getName())
                .clas(clas)
                .race(race)
                .subclass(subclass)
                .level(characterDTO.getLevel())
                .background(background)
                .alignment(characterDTO.getAlignment())
                .playerName(characterDTO.getPlayerName())
                .strengthStat(strengthStatistic)
                .dexterityStat(dexterityStatistic)
                .constitutionStat(constitutionStatistic)
                .intelligenceStat(intelligenceStatistic)
                .wisdomStat(wisdomStatistic)
                .charismaStat(charismaStatistic)
                .armorClass(characterDTO.getArmorClass())
                .totalHitDice(characterDTO.getTotalHitDice())
                .weapons(weaponList)
                .personaltyTraits(characterDTO.getPersonaltyTraits())
                .ideals(characterDTO.getIdeals())
                .bonds(characterDTO.getBonds())
                .flaws(characterDTO.getFlaws())
                .age(characterDTO.getAge())
                .eyes(characterDTO.getEyes())
                .height(characterDTO.getHeight())
                .skin(characterDTO.getSkin())
                .weight(characterDTO.getWeight())
                .hair(characterDTO.getHair())
                .appearance(characterDTO.getAppearance())
                .backstory(characterDTO.getBackstory())
                .build();
    }
}
