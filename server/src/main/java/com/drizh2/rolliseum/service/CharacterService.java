package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.dto.CharacterDTO;
import com.drizh2.rolliseum.entity.Character;
import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.Race;
import com.drizh2.rolliseum.entity.User;
import com.drizh2.rolliseum.facade.CharacterFacade;
import com.drizh2.rolliseum.facade.ClassFacade;
import com.drizh2.rolliseum.facade.RaceFacade;
import com.drizh2.rolliseum.repository.CharacterRepository;
import com.drizh2.rolliseum.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class CharacterService {

    public static final Logger LOG = LoggerFactory.getLogger(CharacterService.class);

    private final UserRepository userRepository;
    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(UserRepository userRepository, CharacterRepository characterRepository) {
        this.userRepository = userRepository;
        this.characterRepository = characterRepository;
    }

    public Character createCharacter(CharacterDTO characterDTO, Principal principal) {
        User user = getUserByPrincipal(principal);
        Character character = CharacterFacade.characterDTOToCharacter(characterDTO);

        character.setUser(user);

        LOG.info("User {} is creating character", user.getUsername());
        return characterRepository.save(character);
    }

    public Character updateCharacter(CharacterDTO characterDTO, Long id) {
        Character character = getCharacterById(id);

        character = CharacterFacade.characterDTOToCharacter(characterDTO);

        return characterRepository.save(character);
    }

    private User getUserByPrincipal(Principal principal) {
        return userRepository.findUserByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User has not been found!"));
    }

    public Character getCharacterById(Long id) {
        return characterRepository.findCharacterById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Character has not been found!"));
    }
}
