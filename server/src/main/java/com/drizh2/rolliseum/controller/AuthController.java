package com.drizh2.rolliseum.controller;

import com.drizh2.rolliseum.payload.request.LoginRequest;
import com.drizh2.rolliseum.payload.request.SignupRequest;
import com.drizh2.rolliseum.payload.response.JWTSuccessResponse;
import com.drizh2.rolliseum.payload.response.MessageResponse;
import com.drizh2.rolliseum.security.JWTProvider;
import com.drizh2.rolliseum.security.SecurityConstants;
import com.drizh2.rolliseum.service.UserService;
import com.drizh2.rolliseum.validator.ResponseErrorValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth/")
@PreAuthorize("permitAll()")
public class AuthController {

    private final UserService userService;
    private final JWTProvider jwtProvider;
    private final ResponseErrorValidator responseErrorValidator;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(UserService userService, JWTProvider jwtProvider, ResponseErrorValidator responseErrorValidator, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
        this.responseErrorValidator = responseErrorValidator;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("signin")
    public ResponseEntity<Object> authenticateUser(@Valid @RequestBody LoginRequest request,
                                                   BindingResult bindingResult) {

        ResponseEntity<Object> errorMap = responseErrorValidator.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errorMap)) return errorMap;

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = SecurityConstants.TOKEN_PREFIX + jwtProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTSuccessResponse(true, jwt));
    }

    @PostMapping("signup")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody SignupRequest request,
                                               BindingResult bindingResult) {
        ResponseEntity<Object> errorMap = responseErrorValidator.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errorMap)) return errorMap;

        userService.createUser(request);
        return ResponseEntity.ok(new MessageResponse("User has been successfully created!"));
    }

    @GetMapping("activate/{code}")
    public ResponseEntity<Object> activateUser(@PathVariable String code) {
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            return ResponseEntity.ok(new MessageResponse("User has been successfully activated!"));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("User activation failed!"));
    }
}
