package com.drizh2.rolliseum.repository;

import com.drizh2.rolliseum.entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Long> {
    Optional<Weapon> findWeaponById(Long id);
    Optional<Weapon> findWeaponByName(String name);
}
