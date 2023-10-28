package com.drizh2.rolliseum.dto;

import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.Race;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CharacterDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Class clas;
    @NotNull
    private Race race;
}
