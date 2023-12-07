package com.drizh2.rolliseum.controller;

import com.drizh2.rolliseum.dto.CharacterDTO;
import com.drizh2.rolliseum.entity.Character;
import com.drizh2.rolliseum.entity.Class;
import com.drizh2.rolliseum.entity.Race;
import com.drizh2.rolliseum.entity.User;
import com.drizh2.rolliseum.facade.CharacterFacade;
import com.drizh2.rolliseum.payload.response.MessageResponse;
import com.drizh2.rolliseum.service.CharacterService;
import com.drizh2.rolliseum.service.ClassService;
import com.drizh2.rolliseum.service.RaceService;
import com.drizh2.rolliseum.service.UserService;
import com.drizh2.rolliseum.validator.ResponseErrorValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/character")
public class CharacterController {

    private final CharacterService characterService;
    private final ResponseErrorValidator responseErrorValidator;
    private final UserService userService;
    private final RaceService raceService;
    private final ClassService classService;

    @Autowired
    public CharacterController(CharacterService characterService, ResponseErrorValidator responseErrorValidator, UserService userService, RaceService raceService, ClassService classService) {
        this.characterService = characterService;
        this.responseErrorValidator = responseErrorValidator;
        this.userService = userService;
        this.raceService = raceService;
        this.classService = classService;
    }

    @GetMapping("/{characterId}")
    public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable("characterId") String characterId) {
        Character character = characterService.getCharacterById(Long.parseLong(characterId));
        CharacterDTO characterDTO = CharacterFacade.characterToCharacterDTO(character);

        return new ResponseEntity<>(characterDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createCharacter(@Valid @RequestBody CharacterDTO characterDTO,
                                                        BindingResult bindingResult,
                                                        Principal principal) {

        ResponseEntity<Object> errorMap = responseErrorValidator.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errorMap)) {
            return errorMap;
        }

        Character character = characterService.createCharacter(characterDTO, principal);
        CharacterDTO finalCharacter = CharacterFacade.characterToCharacterDTO(character);

        return new ResponseEntity<>(finalCharacter, HttpStatus.OK);
    }

    @PostMapping("/{characterId}/race")
    public ResponseEntity<Object> raceAddition(
                                               @PathVariable("characterId") String characterId,
                                               @RequestBody String raceId,
                                               Principal principal) {

        User currentUser = userService.getCurrentUser(principal);
        List<Character> characters = currentUser.getCharacters();

        Optional<Character> optionalCharacter = characters.stream()
                .filter(ch -> ch.getId() == Long.parseLong(characterId))
                .findFirst();

        if (optionalCharacter.isPresent()) {
            Race race = raceService.getRaceById(Long.parseLong(raceId));
            Character character = optionalCharacter.get();
            character.setRace(race);

            CharacterDTO characterDTO = CharacterFacade.characterToCharacterDTO(character);
            characterService.updateCharacter(characterDTO, Long.parseLong(characterId));
            return ResponseEntity.ok(characterDTO);
        } else {
            return new ResponseEntity<>(new MessageResponse("This character does not belongs to you!"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{characterId}/class")
    public ResponseEntity<Object> classAddition(@PathVariable("characterId") String characterId,
                                                @RequestBody String classId,
                                                Principal principal) {
        User currentUser = userService.getCurrentUser(principal);
        List<Character> characters = currentUser.getCharacters();

        Optional<Character> optionalCharacter = characters.stream()
                .filter(ch -> ch.getId() == Long.parseLong(characterId))
                .findFirst();

        if (optionalCharacter.isPresent()) {
            Class clas = classService.getClassById(Long.parseLong(classId));
            Character character = optionalCharacter.get();
            character.setClas(clas);

            CharacterDTO characterDTO = CharacterFacade.characterToCharacterDTO(character);
            characterService.updateCharacter(characterDTO, Long.parseLong(characterId));
            return ResponseEntity.ok(characterDTO);
        } else {
            return new ResponseEntity<>(new MessageResponse("This character does not belongs to you!"), HttpStatus.BAD_REQUEST);
        }
    }

}
