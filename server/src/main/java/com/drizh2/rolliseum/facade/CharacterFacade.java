package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.*;
import com.drizh2.rolliseum.entity.Character;
import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.*;

import java.util.List;
import java.util.Objects;

public class CharacterFacade {

    private CharacterFacade() {}

    public static CharacterDTO characterToCharacterDTO(Character character) {

        CharacterDTO characterDTO = CharacterDTO.builder()
                .name(character.getName())
                .level(character.getLevel())
                .alignment(character.getAlignment())
                .playerName(character.getPlayerName())
                .armorClass(character.getArmorClass())
                .totalHitDice(character.getTotalHitDice())
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

        if (Objects.nonNull(character.getClas())) {
            ClassDTO classDTO = ClassFacade.classToClassDTO(character.getClas());
            characterDTO.setClas(classDTO);
        }

        if (Objects.nonNull(character.getRace())) {
            RaceDTO raceDTO = RaceFacade.raceToRaceDTO(character.getRace());
            characterDTO.setRace(raceDTO);
        }

        if (Objects.nonNull(character.getSubclass())) {
            SubclassDTO subclassDTO = SubclassFacade.subclassToDTO(character.getSubclass());
            characterDTO.setSubclass(subclassDTO);
        }

        if (Objects.nonNull(character.getBackground())) {
            BackgroundDTO backgroundDTO = BackgroundFacade.backgroundToDTO(character.getBackground());
            characterDTO.setBackground(backgroundDTO);
        }

        if (Objects.nonNull(character.getStrengthStat()) &&
                Objects.nonNull(character.getDexterityStat()) &&
                Objects.nonNull(character.getConstitutionStat()) &&
                Objects.nonNull(character.getIntelligenceStat()) &&
                Objects.nonNull(character.getWisdomStat()) &&
                Objects.nonNull(character.getCharismaStat())) {

            StatisticDTO strengthStatisticDTO = StatisticFacade.statisticToStatisticDTO(character.getStrengthStat());
            StatisticDTO dexterityStatisticDTO = StatisticFacade.statisticToStatisticDTO(character.getDexterityStat());
            StatisticDTO constitutionStatisticDTO = StatisticFacade.statisticToStatisticDTO(character.getConstitutionStat());
            StatisticDTO intelligenceStatisticDTO = StatisticFacade.statisticToStatisticDTO(character.getIntelligenceStat());
            StatisticDTO wisdomStatisticDTO = StatisticFacade.statisticToStatisticDTO(character.getWisdomStat());
            StatisticDTO charismaStatisticDTO = StatisticFacade.statisticToStatisticDTO(character.getCharismaStat());

            characterDTO.setStrengthStat(strengthStatisticDTO);
            characterDTO.setDexterityStat(dexterityStatisticDTO);
            characterDTO.setConstitutionStat(constitutionStatisticDTO);
            characterDTO.setIntelligenceStat(intelligenceStatisticDTO);
            characterDTO.setWisdomStat(wisdomStatisticDTO);
            characterDTO.setCharismaStat(charismaStatisticDTO);
        }

        if (Objects.nonNull(character.getWeapons())) {
            List<WeaponDTO> weaponDTOList = character.getWeapons().stream()
                    .map(WeaponFacade::weaponToWeaponDTO)
                    .toList();

            characterDTO.setWeapons(weaponDTOList);
        }

        return characterDTO;
    }

    public static Character characterDTOToCharacter(CharacterDTO characterDTO) {

        Character character = Character.builder()
                .name(characterDTO.getName())
                .level(characterDTO.getLevel())
                .alignment(characterDTO.getAlignment())
                .playerName(characterDTO.getPlayerName())
                .armorClass(characterDTO.getArmorClass())
                .totalHitDice(characterDTO.getTotalHitDice())
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

        if (Objects.nonNull(characterDTO.getClas())) {
            Class clas = ClassFacade.classDTOToClass(characterDTO.getClas());
            character.setClas(clas);
        }

        if (Objects.nonNull(characterDTO.getRace())) {
            Race race = RaceFacade.raceDTOToRace(characterDTO.getRace());
            character.setRace(race);
        }

        if (Objects.nonNull(characterDTO.getSubclass())) {
            Subclass subclass = SubclassFacade.subclassDTOToSubclass(characterDTO.getSubclass());
            character.setSubclass(subclass);
        }

        if (Objects.nonNull(characterDTO.getBackground())) {
            Background background = BackgroundFacade.DTOToBackground(characterDTO.getBackground());
            character.setBackground(background);
        }

        if (Objects.nonNull(characterDTO.getStrengthStat()) &&
            Objects.nonNull(characterDTO.getDexterityStat()) &&
            Objects.nonNull(characterDTO.getConstitutionStat()) &&
            Objects.nonNull(characterDTO.getIntelligenceStat()) &&
            Objects.nonNull( characterDTO.getWisdomStat()) &&
            Objects.nonNull(characterDTO.getCharismaStat())) {

            Statistic strengthStatistic = StatisticFacade.statisticDTOToStatistic(characterDTO.getStrengthStat());
            Statistic dexterityStatistic = StatisticFacade.statisticDTOToStatistic(characterDTO.getDexterityStat());
            Statistic constitutionStatistic = StatisticFacade.statisticDTOToStatistic(characterDTO.getConstitutionStat());
            Statistic intelligenceStatistic = StatisticFacade.statisticDTOToStatistic(characterDTO.getIntelligenceStat());
            Statistic wisdomStatistic = StatisticFacade.statisticDTOToStatistic(characterDTO.getWisdomStat());
            Statistic charismaStatistic = StatisticFacade.statisticDTOToStatistic(characterDTO.getCharismaStat());

            character.setStrengthStat(strengthStatistic);
            character.setDexterityStat(dexterityStatistic);
            character.setConstitutionStat(constitutionStatistic);
            character.setIntelligenceStat(intelligenceStatistic);
            character.setWisdomStat(wisdomStatistic);
            character.setCharismaStat(charismaStatistic);
        }

        if (Objects.nonNull(characterDTO.getWeapons())) {
            List<Weapon> weaponList = characterDTO.getWeapons().stream()
                    .map(WeaponFacade::weaponDTOToWeapon)
                    .toList();

            character.setWeapons(weaponList);
        }

        return character;
    }
}
