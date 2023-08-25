package com.drizh2.rolliseum.repository;

import com.drizh2.rolliseum.entity.SkillIncrement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillIncrementRepository extends JpaRepository<SkillIncrement, Long> {
    Optional<SkillIncrement> findSkillIncrementByNameAndModificator(String name, Integer modificator);
}
