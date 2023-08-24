package com.drizh2.rolliseum.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(columnDefinition = "text")
    private String content;
    @JsonIgnore
    @ManyToOne
    private Class aClass;
    @JsonIgnore
    @ManyToOne
    private Race race;
    @JsonIgnore
    @ManyToOne
    private Subclass subclass;
}
