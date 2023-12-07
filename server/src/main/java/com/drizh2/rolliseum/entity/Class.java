package com.drizh2.rolliseum.entity;

import com.drizh2.rolliseum.entity.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "classes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private Classes name;
    @Column(nullable = false)
    private int hitDice;
    @Column(nullable = false)
    private int firstLevelHits;
    @Column(nullable = false)
    private int nextLevelHits;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clas")
    private List<Subclass> subclasses = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "clas", orphanRemoval = true)
    private List<Feature> features = new ArrayList<>();

    @ElementCollection(targetClass = ArmorTypes.class)
    @JoinTable(name = "class_armor", joinColumns = @JoinColumn(name = "class_id"))
    @Enumerated(EnumType.STRING)
    private List<ArmorTypes> armor;

    @ElementCollection(targetClass = WeaponTypes.class)
    @JoinTable(name = "class_weapons", joinColumns = @JoinColumn(name = "class_id"))
    @Enumerated(EnumType.STRING)
    private List<WeaponTypes> weapons;

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Tool> tools;

    @ElementCollection(targetClass = SavingThrows.class)
    @JoinTable(name = "class_saving_throws", joinColumns = @JoinColumn(name = "class_id"))
    @Enumerated(EnumType.STRING)
    private List<SavingThrows> savingThrows;

    @ElementCollection(targetClass = Skills.class)
    @JoinTable(name = "class_skills", joinColumns = @JoinColumn(name = "class_id"))
    @Enumerated(EnumType.STRING)
    private List<Skills> skills;

    @Column(nullable = false)
    private int countOfStats;
    @Column(nullable = false)
    private int spellSavingThrow;
}
