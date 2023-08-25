package com.drizh2.rolliseum.repository;

import com.drizh2.rolliseum.entity.Background;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BackgroundRepository extends JpaRepository<Background, Long> {
    Optional<Background> findBackgroundByName(String name);
    Optional<Background> findBackgroundById(Long id);
}
