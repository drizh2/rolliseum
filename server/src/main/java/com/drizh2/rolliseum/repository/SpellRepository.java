package com.drizh2.rolliseum.repository;

import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.Spell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Long> {
    Optional<Spell> findSpellById(Long id);
    Optional<Spell> findSpellByName(String name);
    @Query("SELECT s FROM Spell s JOIN s.classes c WHERE c = :class ORDER BY s.name")
    List<Spell> findAllByClasOrderByName(@Param("class") Class clas);
}
