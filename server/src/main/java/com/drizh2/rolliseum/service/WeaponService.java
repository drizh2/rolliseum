package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.WeaponDTO;
import com.drizh2.rolliseum.entity.Weapon;
import com.drizh2.rolliseum.repository.WeaponRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponService {

    public static final Logger LOG = LoggerFactory.getLogger(WeaponService.class);

    private final WeaponRepository weaponRepository;

    @Autowired
    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    public Weapon createWeapon(WeaponDTO weaponDTO) {
        Weapon weapon = new Weapon();

        weapon.setName(weaponDTO.getName());
        weapon.setType(weaponDTO.getType());
        weapon.setRange(weaponDTO.getRange());
        weapon.setAttackBonus(weaponDTO.getAttackBonus());
        weapon.setDamage(weaponDTO.getDamage());
        weapon.setDamageType(weaponDTO.getDamageType());

        LOG.info("Creating {} weapon", weapon.getName());

        return weaponRepository.save(weapon);
    }

}
