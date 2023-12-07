package com.drizh2.rolliseum.controller;

import com.drizh2.rolliseum.dto.UserDTO;
import com.drizh2.rolliseum.entity.User;
import com.drizh2.rolliseum.facade.UserFacade;
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

@CrossOrigin
@RequestMapping("/api/user")
@RestController
public class UserController {

    private final UserService userService;
    private final ResponseErrorValidator responseErrorValidator;

    @Autowired
    public UserController(UserService userService, ResponseErrorValidator responseErrorValidator) {
        this.userService = userService;
        this.responseErrorValidator = responseErrorValidator;
    }

    @GetMapping("/")
    public ResponseEntity<UserDTO> getCurrentUser(Principal principal) {
        User user = userService.getCurrentUser(principal);
        UserDTO userDTO = UserFacade.userToUserDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") String userId) {
        User user = userService.getUserById(Long.parseLong(userId));
        UserDTO userDTO = UserFacade.userToUserDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserDTO userDTO,
                                              BindingResult bindingResult,
                                              Principal principal) {
        ResponseEntity<Object> errorMap = responseErrorValidator.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errorMap)) return errorMap;

        User user = userService.updateUser(userDTO, principal);
        UserDTO userDTOResult = UserFacade.userToUserDTO(user);

        return new ResponseEntity<>(userDTOResult, HttpStatus.OK);
    }
}
