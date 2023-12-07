package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.SpellDTO;
import com.drizh2.rolliseum.entity.Spell;
import com.drizh2.rolliseum.facade.SpellFacade;
import com.drizh2.rolliseum.repository.SpellRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SpellService {

    public static final Logger LOG = LoggerFactory.getLogger(SpellService.class);

    private final SpellRepository spellRepository;

    @Autowired
    public SpellService(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }

    public Spell createSpellForClass(SpellDTO spellDTO) {
        Spell spell = SpellFacade.spellDTOToSpell(spellDTO);

        String collect = spell.getClasses().stream()
                .map(c -> c.getName().name())
                .collect(Collectors.joining(", "));

        LOG.info("Creating spell {} for classes {}", spell.getName(), collect);

        return spellRepository.save(spell);
    }

    public Spell createSpellForRace(SpellDTO spellDTO) {
        Spell spell = SpellFacade.spellDTOToSpell(spellDTO);

        String collect = spell.getRaces().stream()
                .map(r -> r.getName().name())
                .collect(Collectors.joining(", "));

        LOG.info("Creating spell {} for races {}", spell.getName(), collect);

        return spellRepository.save(spell);
    }

    public Spell createSpellForClassAndRace(SpellDTO spellDTO) {
        Spell spell = SpellFacade.spellDTOToSpell(spellDTO);

        String collectClasses = spell.getClasses().stream()
                .map(c -> c.getName().name())
                .collect(Collectors.joining(", "));

        String collectRaces = spell.getRaces().stream()
                .map(r -> r.getName().name())
                .collect(Collectors.joining(", "));

        LOG.info("Creating spell {} for classes {} and races {}", spell.getName(), collectClasses, collectRaces);

        return spellRepository.save(spell);
    }

}
