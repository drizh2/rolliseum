package com.drizh2.rolliseum.repository;

import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.enums.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    Optional<Class> findClassById(Long id);
    Optional<Class> findClassByName(Classes name);
}
