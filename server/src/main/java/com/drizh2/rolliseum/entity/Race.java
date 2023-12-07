package com.drizh2.rolliseum.entity;

import com.drizh2.rolliseum.entity.enums.Races;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "races")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private Races name;
    @Column(nullable = false)
    private String type;
    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<SkillIncrement> stats;
    @Column(nullable = false)
    private String size;
    @Column(nullable = false)
    private int speed;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "race", orphanRemoval = true)
    private List<Feature> raceFeatures = new ArrayList<>();
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> languages;
}
