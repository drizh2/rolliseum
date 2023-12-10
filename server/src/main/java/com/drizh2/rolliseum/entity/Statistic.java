package com.drizh2.rolliseum.entity;

import com.drizh2.rolliseum.entity.enums.Skills;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @ElementCollection(targetClass = Skills.class)
    @JoinTable(name = "statistic_skills", joinColumns = @JoinColumn(name = "statistic_id"))
    @Enumerated(EnumType.STRING)
    private List<Skills> skills = new ArrayList<>();
}
