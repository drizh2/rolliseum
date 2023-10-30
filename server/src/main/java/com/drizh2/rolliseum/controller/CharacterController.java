package com.drizh2.rolliseum.controller;

import com.drizh2.rolliseum.dto.CharacterDTO;
import com.drizh2.rolliseum.entity.Character;
import com.drizh2.rolliseum.facade.CharacterFacade;
import com.drizh2.rolliseum.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/character")
public class CharacterController {

    private final CharacterService characterService;
    private final CharacterFacade characterFacade;

    @Autowired
    public CharacterController(CharacterService characterService, CharacterFacade characterFacade) {
        this.characterService = characterService;
        this.characterFacade = characterFacade;
    }

    @GetMapping("/{characterId}")
    public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable("characterId") Long characterId) {
        Character character = characterService.getCharacterById(characterId);
        CharacterDTO characterDTO = characterFacade.characterToCharacterDTO(character);

        return new ResponseEntity<>(characterDTO, HttpStatus.OK);
    }
}
