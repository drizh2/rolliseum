package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.FeatureDTO;
import com.drizh2.rolliseum.dto.RaceDTO;
import com.drizh2.rolliseum.dto.SkillIncrementDTO;
import com.drizh2.rolliseum.entity.Race;
import com.drizh2.rolliseum.entity.SkillIncrement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RaceFacade {

    private RaceFacade() {}

    public static RaceDTO raceToRaceDTO(Race race) {

        RaceDTO raceDTO = RaceDTO.builder()
                .id(race.getId())
                .name(race.getName())
                .type(race.getType())
                .size(race.getSize())
                .speed(race.getSpeed())
                .languages(race.getLanguages())
                .build();

        List<SkillIncrementDTO> skillIncrementDTOList = race.getStats().stream()
                .map(SkillIncrementFacade::skillIncrementToSkillIncrementDTO)
                .toList();
        raceDTO.setStats(skillIncrementDTOList);

        if (Objects.nonNull(race.getRaceFeatures())) {
            List<FeatureDTO> featureDTOList = race.getRaceFeatures().stream()
                    .map(FeatureFacade::featureToDTO)
                    .toList();

            raceDTO.setRaceFeatures(featureDTOList);
        }

        return raceDTO;
    }

    public static Race raceDTOToRace(RaceDTO raceDTO) {
        List<SkillIncrement> skillIncrementList = raceDTO.getStats().stream()
                .map(SkillIncrementFacade::skillIncrementDTOToSkillIncrement)
                .toList();

        return Race.builder()
                .id(raceDTO.getId())
                .name(raceDTO.getName())
                .type(raceDTO.getType())
                .stats(skillIncrementList)
                .size(raceDTO.getSize())
                .speed(raceDTO.getSpeed())
                .languages(raceDTO.getLanguages())
                .raceFeatures(new ArrayList<>())
                .build();
    }

    public static RaceDTO getRequestRaceMapping(Race race) {
        RaceDTO raceDTO = RaceDTO.builder()
                .id(race.getId())
                .name(race.getName())
                .type(race.getType())
                .size(race.getSize())
                .speed(race.getSpeed())
                .languages(race.getLanguages())
                .build();

        List<SkillIncrementDTO> skillIncrementDTOList = race.getStats().stream()
                .map(SkillIncrementFacade::skillIncrementToSkillIncrementDTO)
                .toList();
        raceDTO.setStats(skillIncrementDTOList);

        if (Objects.nonNull(race.getRaceFeatures())) {
            List<FeatureDTO> featureDTOList = race.getRaceFeatures().stream()
                    .map(FeatureFacade::getRequestMapper)
                    .toList();

            raceDTO.setRaceFeatures(featureDTOList);
        }

        return raceDTO;
    }
}
