package com.drizh2.rolliseum.repository;

import com.drizh2.rolliseum.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
    Optional<Tool> findToolById(Long id);
    Optional<Tool> findToolByName(String name);
}
