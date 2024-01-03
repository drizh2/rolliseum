package com.drizh2.rolliseum.controller;

import com.drizh2.rolliseum.dto.BackgroundDTO;
import com.drizh2.rolliseum.entity.Background;
import com.drizh2.rolliseum.facade.BackgroundFacade;
import com.drizh2.rolliseum.service.BackgroundService;
import com.drizh2.rolliseum.validator.ResponseErrorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/background")
public class BackgroundController {
    private final BackgroundService backgroundService;
    private final ResponseErrorValidator responseErrorValidator;

    @Autowired
    public BackgroundController(BackgroundService backgroundService, ResponseErrorValidator responseErrorValidator) {
        this.backgroundService = backgroundService;
        this.responseErrorValidator = responseErrorValidator;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createBackground(@RequestBody BackgroundDTO backgroundDTO,
                                                          BindingResult bindingResult) {
        ResponseEntity<Object> errorMap = responseErrorValidator.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errorMap)) {
            return errorMap;
        }

        Background background = backgroundService.createBackground(backgroundDTO);
        BackgroundDTO resultBackground = BackgroundFacade.backgroundToDTO(background);

        return new ResponseEntity<>(resultBackground, HttpStatus.OK);
    }

    @GetMapping("/{backgroundId}")
    public ResponseEntity<BackgroundDTO> getBackgroundById(@PathVariable Long backgroundId) {
        Background background = backgroundService.getBackgroundById(backgroundId);
        BackgroundDTO resultBackGround = BackgroundFacade.backgroundToDTO(background);

        return new ResponseEntity<>(resultBackGround, HttpStatus.OK);
    }
}
