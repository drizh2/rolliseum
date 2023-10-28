package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.SpellDTO;
import com.drizh2.rolliseum.entity.Spell;
import org.springframework.stereotype.Component;

@Component
public class SpellFacade {
    public SpellDTO spellToSpellDTO(Spell spell) {
        SpellDTO spellDTO = new SpellDTO();

        spellDTO.setName(spell.getName());
        spellDTO.setTime(spell.getTime());
        spellDTO.setDistance(spell.getDistance());
        spellDTO.setDuration(spell.getDuration());
        spellDTO.setComponents(spell.getComponents());
        spellDTO.setCaption(spell.getCaption());
        spellDTO.setClasses(spell.getClasses());
        spellDTO.setRaces(spell.getRaces());

        return spellDTO;
    }
}
