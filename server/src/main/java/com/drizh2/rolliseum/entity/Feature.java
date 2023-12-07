package com.drizh2.rolliseum.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "features")
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinColumn(name = "class_id")
    private Class clas;
    @JsonIgnore
    @Column
    private int classLevel;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subclass_id")
    private Subclass subclass;
    @JsonIgnore
    @Column
    private int subclassLevel;
}
