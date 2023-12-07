package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.ClassDTO;
import com.drizh2.rolliseum.dto.RaceDTO;
import com.drizh2.rolliseum.dto.SpellDTO;
import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.Race;
import com.drizh2.rolliseum.entity.Spell;

import java.util.List;

public class SpellFacade {

    private SpellFacade() {}

    public static SpellDTO spellToSpellDTO(Spell spell) {
        List<ClassDTO> classDTOList = spell.getClasses().stream()
                .map(ClassFacade::classToClassDTO)
                .toList();

        List<RaceDTO> raceDTOList = spell.getRaces().stream()
                .map(RaceFacade::raceToRaceDTO)
                .toList();

        return SpellDTO.builder()
                .id(spell.getId())
                .name(spell.getName())
                .time(spell.getTime())
                .distance(spell.getDistance())
                .duration(spell.getDuration())
                .components(spell.getComponents())
                .caption(spell.getCaption())
                .classes(classDTOList)
                .races(raceDTOList)
                .build();
    }

    public static Spell spellDTOToSpell(SpellDTO spellDTO) {
        List<Class> classList = spellDTO.getClasses().stream()
                .map(ClassFacade::classDTOToClass)
                .toList();

        List<Race> raceList = spellDTO.getRaces().stream()
                .map(RaceFacade::raceDTOToRace)
                .toList();

        return Spell.builder()
                .id(spellDTO.getId())
                .name(spellDTO.getName())
                .time(spellDTO.getTime())
                .distance(spellDTO.getDistance())
                .duration(spellDTO.getDuration())
                .components(spellDTO.getComponents())
                .caption(spellDTO.getCaption())
                .classes(classList)
                .races(raceList)
                .build();
    }
}
