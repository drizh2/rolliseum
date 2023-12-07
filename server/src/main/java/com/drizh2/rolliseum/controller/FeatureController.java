package com.drizh2.rolliseum.controller;

import com.drizh2.rolliseum.dto.FeatureDTO;
import com.drizh2.rolliseum.entity.Feature;
import com.drizh2.rolliseum.facade.FeatureFacade;
import com.drizh2.rolliseum.service.FeatureService;
import com.drizh2.rolliseum.validator.ResponseErrorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/feature")
public class FeatureController {
    private final FeatureService featureService;
    private final ResponseErrorValidator responseErrorValidator;

    @Autowired
    public FeatureController(FeatureService featureService, ResponseErrorValidator responseErrorValidator) {
        this.featureService = featureService;
        this.responseErrorValidator = responseErrorValidator;
    }

    @PostMapping("/createForRace")
    public ResponseEntity<Object> createFeatureForRace(@RequestBody FeatureDTO featureDTO,
                                                BindingResult bindingResult) {
        ResponseEntity<Object> errorMap = responseErrorValidator.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errorMap)) {
            return errorMap;
        }

        Feature feature = featureService.createFeatureForRace(featureDTO);
        FeatureDTO finalFeature = FeatureFacade.featureToDTO(feature);

        return ResponseEntity.ok(finalFeature);
    }

    @PostMapping("/createForClass")
    public ResponseEntity<Object> createFeatureForClass(@RequestBody FeatureDTO featureDTO,
                                                       BindingResult bindingResult) {
        ResponseEntity<Object> errorMap = responseErrorValidator.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errorMap)) {
            return errorMap;
        }

        Feature feature = featureService.createFeatureForClass(featureDTO);
        FeatureDTO finalFeature = FeatureFacade.featureToDTO(feature);

        return ResponseEntity.ok(finalFeature);
    }

    @PostMapping("/createForSubclass")
    public ResponseEntity<Object> createFeatureForSubclass(@RequestBody FeatureDTO featureDTO,
                                                       BindingResult bindingResult) {
        ResponseEntity<Object> errorMap = responseErrorValidator.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errorMap)) {
            return errorMap;
        }

        Feature feature = featureService.createFeatureForSubclass(featureDTO);
        FeatureDTO finalFeature = FeatureFacade.featureToDTO(feature);

        return ResponseEntity.ok(finalFeature);
    }

    @GetMapping("/{featureId}")
    public ResponseEntity<FeatureDTO> getFeatureById(@PathVariable("featureId") String featureId) {
        Feature feature = featureService.getFeatureById(Long.parseLong(featureId));
        FeatureDTO featureDTO = FeatureFacade.featureToDTO(feature);

        return new ResponseEntity<>(featureDTO, HttpStatus.OK);
    }
}
