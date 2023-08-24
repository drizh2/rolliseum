package com.drizh2.rolliseum.entity;

import com.drizh2.rolliseum.entity.enums.Races;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private Races name;
    @Column(nullable = false)
    private String type;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<SkillIncrement> stats;
    @Column(nullable = false)
    private String size;
    @Column(nullable = false)
    private int speed;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "race", orphanRemoval = true)
    private List<Feature> raceFeatures;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> languages;
}
