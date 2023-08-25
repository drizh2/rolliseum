package com.drizh2.rolliseum.repository;

import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.Subclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubclassRepository extends JpaRepository<Subclass, Long> {
    Optional<Subclass> findSubclassById(Long id);
    Optional<Subclass> findSubclassByName(String name);
    List<Subclass> findAllByClasOrderByNameAsc(Class clas);
}
