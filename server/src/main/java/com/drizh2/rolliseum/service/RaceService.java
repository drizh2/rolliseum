package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.FeatureDTO;
import com.drizh2.rolliseum.dto.RaceDTO;
import com.drizh2.rolliseum.entity.Feature;
import com.drizh2.rolliseum.entity.Race;
import com.drizh2.rolliseum.exception.RaceNotFoundException;
import com.drizh2.rolliseum.facade.FeatureFacade;
import com.drizh2.rolliseum.facade.RaceFacade;
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

    @Autowired
    public RaceService(RaceRepository raceRepository, FeatureService featureService) {
        this.raceRepository = raceRepository;
        this.featureService = featureService;
    }

    public Race createRace(RaceDTO raceDTO) {
        Race race = RaceFacade.raceDTOToRace(raceDTO);

        LOG.info("Race {} is creating!", race.getName());

        race = raceRepository.save(race);
        for (FeatureDTO featureDTO : raceDTO.getRaceFeatures()) {
            Feature feature = FeatureFacade.featureDTOToFeature(featureDTO);
            feature.setRace(race);
            Feature tempFeature = featureService.createFeatureForRace(FeatureFacade.featureToDTO(feature));
            race.getRaceFeatures().add(tempFeature);
        }
        return race;
    }

    public Race getRaceById(Long id) {
        return raceRepository.findRaceById(id)
                .orElseThrow(() -> new RaceNotFoundException("Race has not been found"));
    }
}
