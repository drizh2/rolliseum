package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.WeaponDTO;
import com.drizh2.rolliseum.entity.Weapon;
import org.springframework.stereotype.Component;

@Component
public class WeaponFacade {
    public WeaponDTO weaponToWeaponDTO(Weapon weapon) {
        WeaponDTO weaponDTO = new WeaponDTO();

        weaponDTO.setName(weapon.getName());
        weaponDTO.setType(weapon.getType());
        weaponDTO.setRange(weapon.getRange());
        weaponDTO.setAttackBonus(weapon.getAttackBonus());
        weaponDTO.setDamage(weapon.getDamage());
        weaponDTO.setDamageType(weapon.getDamageType());

        return weaponDTO;
    }
}
