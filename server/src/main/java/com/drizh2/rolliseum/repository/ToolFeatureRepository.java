package com.drizh2.rolliseum.repository;

import com.drizh2.rolliseum.entity.ToolFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToolFeatureRepository extends JpaRepository<ToolFeature, Long> {
    Optional<ToolFeature> findToolFeatureById(Long id);
    Optional<ToolFeature> findToolFeatureByName(String name);
}
