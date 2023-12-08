package com.drizh2.rolliseum.entity;

import com.drizh2.rolliseum.entity.enums.WeaponTypes;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "weapons")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    @ElementCollection(targetClass = WeaponTypes.class)
    @JoinTable(name = "weapon_types", joinColumns = @JoinColumn(name = "weapon_id"))
    @Enumerated(EnumType.STRING)
    private List<WeaponTypes> types;

    @Column(nullable = false, name = "farness")
    private String range;
    @Column(nullable = false)
    private int attackBonus;
    @Column(nullable = false)
    private int damage;
    @Column
    private String damageType;
}
