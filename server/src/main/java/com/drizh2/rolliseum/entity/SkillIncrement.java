package com.drizh2.rolliseum.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "skill_increments")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillIncrement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer modificator;
}
