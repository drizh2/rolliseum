package com.drizh2.rolliseum.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "subclasses")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subclass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "subclass", orphanRemoval = true)
    private List<Feature> subclassFeatures = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class clas;
}
