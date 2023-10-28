package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.RaceDTO;
import com.drizh2.rolliseum.entity.Race;
import org.springframework.stereotype.Component;

@Component
public class RaceFacade {
    public RaceDTO raceToRaceDTO(Race race) {
        RaceDTO raceDTO = new RaceDTO();

        raceDTO.setName(race.getName());
        raceDTO.setType(race.getType());
        raceDTO.setStats(race.getStats());
        raceDTO.setSize(race.getSize());
        raceDTO.setSpeed(race.getSpeed());
        raceDTO.setRaceFeatures(race.getRaceFeatures());
        raceDTO.setLanguages(race.getLanguages());

        return raceDTO;
    }
}
