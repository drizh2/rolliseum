package com.drizh2.rolliseum.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name="characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Class clas;
    @ManyToOne(fetch = FetchType.LAZY)
    private Subclass subclass;
    @ManyToOne(fetch = FetchType.LAZY)
    private Race race;
    @Column(nullable = false)
    private int level;
    @ManyToOne(fetch = FetchType.LAZY)
    private Background background;
    @Column
    private String alignment;
    @Column
    private String playerName;

    @OneToOne(fetch = FetchType.LAZY)
    private Statistic strengthStat;
    @OneToOne(fetch = FetchType.LAZY)
    private Statistic dexterityStat;
    @OneToOne(fetch = FetchType.LAZY)
    private Statistic constitutionStat;
    @OneToOne(fetch = FetchType.LAZY)
    private Statistic intelligenceStat;
    @OneToOne(fetch = FetchType.LAZY)
    private Statistic wisdomStat;
    @OneToOne(fetch = FetchType.LAZY)
    private Statistic charismaStat;

    @Column
    private int armorClass;
    @Column
    private int currentHitPoints;
    @Column
    private int temporaryHitPoints;
    @Column
    private int totalHitDice;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Weapon> weapons;

    @Column(columnDefinition = "text")
    private String personaltyTraits;
    @Column(columnDefinition = "text")
    private String ideals;
    @Column(columnDefinition = "text")
    private String bonds;
    @Column(columnDefinition = "text")
    private String flaws;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Spell> spells;

    @Column
    private int age;
    @Column
    private String eyes;
    @Column
    private int height;
    @Column
    private String skin;
    @Column
    private int weight;
    @Column
    private String hair;
    @Column(columnDefinition = "text")
    private String appearance;
    @Column(columnDefinition = "text")
    private String backstory;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> treasures;

    @ManyToOne
    private User user;

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(updatable = false)
    private LocalDateTime creationDate;

    @PrePersist
    private void onCreate() {
        this.creationDate = LocalDateTime.now();
    }
}
