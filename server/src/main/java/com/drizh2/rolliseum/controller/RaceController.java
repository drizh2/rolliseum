package com.drizh2.rolliseum.controller;

import com.drizh2.rolliseum.dto.RaceDTO;
import com.drizh2.rolliseum.entity.Race;
import com.drizh2.rolliseum.facade.RaceFacade;
import com.drizh2.rolliseum.service.RaceService;
import com.drizh2.rolliseum.validator.ResponseErrorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/race")
public class RaceController {
    private final RaceService raceService;
    private final ResponseErrorValidator responseErrorValidator;

    @Autowired
    public RaceController(RaceService raceService, ResponseErrorValidator responseErrorValidator) {
        this.raceService = raceService;
        this.responseErrorValidator = responseErrorValidator;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createRace(@RequestBody RaceDTO raceDTO,
                                             BindingResult bindingResult) {

        ResponseEntity<Object> errorMap = responseErrorValidator.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errorMap)) {
            return errorMap;
        }

        Race race = raceService.createRace(raceDTO);
        RaceDTO finalRace = RaceFacade.raceToRaceDTO(race);

        return ResponseEntity.ok(finalRace);
    }

    @GetMapping("/{raceId}")
    public ResponseEntity<RaceDTO> getRaceById(@PathVariable("raceId") String raceId) {
        Race race = raceService.getRaceById(Long.parseLong(raceId));
        RaceDTO raceDTO = RaceFacade.getRequestRaceMapping(race);

        return ResponseEntity.ok(raceDTO);
    }
}
