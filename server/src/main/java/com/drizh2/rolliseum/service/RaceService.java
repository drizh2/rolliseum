package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.RaceDTO;
import com.drizh2.rolliseum.entity.Feature;
import com.drizh2.rolliseum.entity.Race;
import com.drizh2.rolliseum.exception.RaceNotFoundException;
import com.drizh2.rolliseum.facade.FeatureFacade;
import com.drizh2.rolliseum.repository.RaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceService {

    public static final Logger LOG = LoggerFactory.getLogger(RaceService.class);

    private final RaceRepository raceRepository;
    private final FeatureService featureService;
    private final FeatureFacade featureFacade;

    @Autowired
    public RaceService(RaceRepository raceRepository, FeatureService featureService, FeatureFacade featureFacade) {
        this.raceRepository = raceRepository;
        this.featureService = featureService;
        this.featureFacade = featureFacade;
    }

    public Race createRace(RaceDTO raceDTO) {
        Race race = new Race();

        race.setName(raceDTO.getName());
        race.setType(raceDTO.getType());
        race.setStats(raceDTO.getStats());
        race.setSize(raceDTO.getSize());
        race.setSpeed(raceDTO.getSpeed());
        race.setLanguages(raceDTO.getLanguages());

        LOG.info("Race {} is creating!", race.getName());

        race = raceRepository.save(race);
        for (Feature feature : raceDTO.getRaceFeatures()) {
            feature.setRace(race);
            Feature tempFeature = featureService.createFeatureForRace(featureFacade.featureToDTO(feature));
            race.getRaceFeatures().add(tempFeature);
        }
        return race;
    }

    public Race getRaceById(Long id) {
        return raceRepository.findRaceById(id)
                .orElseThrow(() -> new RaceNotFoundException("Race has not been found"));
    }
}
