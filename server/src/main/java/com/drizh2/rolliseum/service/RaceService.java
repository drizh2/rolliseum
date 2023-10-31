package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.RaceDTO;
import com.drizh2.rolliseum.entity.Race;
import com.drizh2.rolliseum.exception.RaceNotFoundException;
import com.drizh2.rolliseum.repository.RaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceService {

    public static final Logger LOG = LoggerFactory.getLogger(RaceService.class);

    private final RaceRepository raceRepository;

    @Autowired
    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public Race createRace(RaceDTO raceDTO) {
        Race race = new Race();

        race.setName(raceDTO.getName());
        race.setType(raceDTO.getType());
        race.setStats(raceDTO.getStats());
        race.setSize(raceDTO.getSize());
        race.setSpeed(raceDTO.getSpeed());
        race.setRaceFeatures(raceDTO.getRaceFeatures());
        race.setLanguages(raceDTO.getLanguages());

        LOG.info("Race {} is creating!", race.getName());

        return raceRepository.save(race);
    }

    public Race getRaceById(Long id) {
        return raceRepository.findRaceById(id)
                .orElseThrow(() -> new RaceNotFoundException("Race has not been found"));
    }
}
