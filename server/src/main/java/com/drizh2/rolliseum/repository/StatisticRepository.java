package com.drizh2.rolliseum.repository;

import com.drizh2.rolliseum.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {
    Optional<Statistic> findStatisticById(Long id);
    Optional<Statistic> findStatisticByName(String name);
}
