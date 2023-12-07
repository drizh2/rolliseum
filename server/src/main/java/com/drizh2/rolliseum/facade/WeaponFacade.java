package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.WeaponDTO;
import com.drizh2.rolliseum.entity.Weapon;

public class WeaponFacade {

    private WeaponFacade() {}

    public static WeaponDTO weaponToWeaponDTO(Weapon weapon) {
        return WeaponDTO.builder()
                .name(weapon.getName())
                .types(weapon.getTypes())
                .range(weapon.getRange())
                .attackBonus(weapon.getAttackBonus())
                .damage(weapon.getDamage())
                .damageType(weapon.getDamageType())
                .build();
    }

    public static Weapon weaponDTOToWeapon(WeaponDTO weaponDTO) {
        return Weapon.builder()
                .name(weaponDTO.getName())
                .types(weaponDTO.getTypes())
                .range(weaponDTO.getRange())
                .attackBonus(weaponDTO.getAttackBonus())
                .damage(weaponDTO.getDamage())
                .damageType(weaponDTO.getDamageType())
                .build();
    }
}
