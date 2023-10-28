package com.drizh2.rolliseum.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Entity
@Data
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int modificator;
    @Column
    private boolean savingThrow;
    @Column
    @ElementCollection(targetClass = Boolean.class)
    private Map<String, Boolean> skills;
}
