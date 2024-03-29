package com.drizh2.rolliseum.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "backgrounds")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Background {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> stats;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> languages;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> equip;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> skills;
    @Column(columnDefinition = "text", nullable = false)
    private String caption;
}
