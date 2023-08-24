package com.drizh2.rolliseum.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column
    private boolean savingThrow;
    @Column
    @ElementCollection(targetClass = Boolean.class)
    private List<Boolean> skills;
}
