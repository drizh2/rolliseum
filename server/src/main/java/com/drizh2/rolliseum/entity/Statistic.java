package com.drizh2.rolliseum.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

@Entity
@Getter
@Setter
@Table(name = "statistics")
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
