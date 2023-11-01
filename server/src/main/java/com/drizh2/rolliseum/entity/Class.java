package com.drizh2.rolliseum.entity;

import com.drizh2.rolliseum.entity.enums.Classes;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Class {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private Classes name;
    @Column(nullable = false)
    private int hitDice;
    @Column(nullable = false)
    private int firstLevelHits;
    @Column(nullable = false)
    private int nextLevelHits;
    @OneToMany
    private List<Subclass> subclasses;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "clas", orphanRemoval = true)
    private List<Feature> features;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> armor;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> weapons;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> tools;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> savingThrows;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> stats;
    @Column(nullable = false)
    private int spellSavingThrow;
}
