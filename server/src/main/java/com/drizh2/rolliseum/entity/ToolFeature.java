package com.drizh2.rolliseum.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "tool_features")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, columnDefinition = "text")
    private String content;
    @ManyToOne
    @JoinColumn(name = "tool_id")
    private Tool tool;
}
