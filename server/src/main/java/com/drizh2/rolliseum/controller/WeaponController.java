package com.drizh2.rolliseum.controller;

import com.drizh2.rolliseum.dto.WeaponDTO;
import com.drizh2.rolliseum.entity.Weapon;
import com.drizh2.rolliseum.facade.WeaponFacade;
import com.drizh2.rolliseum.service.WeaponService;
import com.drizh2.rolliseum.validator.ResponseErrorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weapon")
@CrossOrigin
public class WeaponController {

    private final WeaponService weaponService;
    private final ResponseErrorValidator responseErrorValidator;

    @Autowired
    public WeaponController(WeaponService weaponService, ResponseErrorValidator responseErrorValidator) {
        this.weaponService = weaponService;
        this.responseErrorValidator = responseErrorValidator;
    }

    @GetMapping("/{weaponId}")
    public ResponseEntity<WeaponDTO> getWeaponById(@PathVariable String weaponId) {
        Weapon weapon = weaponService.getWeaponById(Long.parseLong(weaponId));
        WeaponDTO weaponDTO = WeaponFacade.weaponToWeaponDTO(weapon);

        return ResponseEntity.ok(weaponDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createWeapon(@RequestBody WeaponDTO weaponDTO,
                                                  BindingResult bindingResult) {
        ResponseEntity<Object> errorMap = responseErrorValidator.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errorMap)) {
            return errorMap;
        }

        Weapon weapon = weaponService.createWeapon(weaponDTO);
        WeaponDTO finalWeapon = WeaponFacade.weaponToWeaponDTO(weapon);

        return new ResponseEntity<>(finalWeapon, HttpStatus.OK);
    }

}
