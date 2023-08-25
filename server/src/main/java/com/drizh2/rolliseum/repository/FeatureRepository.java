package com.drizh2.rolliseum.repository;

import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.Feature;
import com.drizh2.rolliseum.entity.Race;
import com.drizh2.rolliseum.entity.Subclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
    Optional<Feature> findFeatureById(Long id);
    Optional<Feature> findFeatureByName(String name);
    List<Feature> findAllByClasOrderByClassLevelAsc(Class clas);
    Optional<Feature> findAllByRace(Race race);
    List<Feature> findAllBySubclassOrderBySubclassLevelAsc(Subclass subclass);
}
