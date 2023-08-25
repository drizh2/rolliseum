package com.drizh2.rolliseum.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false, name = "farness")
    private String range;
    @Column(nullable = false)
    private int attackBonus;
    @Column(nullable = false)
    private int damage;
    @Column
    private String damageType;
}
