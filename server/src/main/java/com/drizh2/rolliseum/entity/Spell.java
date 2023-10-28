package com.drizh2.rolliseum.entity;

import com.drizh2.rolliseum.entity.enums.Components;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private String distance;
    @Column(nullable = false)
    private String duration;
    @ElementCollection(targetClass = Components.class)
    @CollectionTable(name = "spell_component",
            joinColumns = @JoinColumn(name = "spell_id"))
    private List<Components> components;
    @Column(columnDefinition = "text")
    private String caption;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Class> classes;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Race> races;
}
