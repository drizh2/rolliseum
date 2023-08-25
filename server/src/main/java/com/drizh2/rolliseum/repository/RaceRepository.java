package com.drizh2.rolliseum.repository;

import com.drizh2.rolliseum.entity.Race;
import com.drizh2.rolliseum.entity.enums.Races;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
    Optional<Race> findRaceById(Long id);
    Optional<Race> findRaceByName(Races race);
}
