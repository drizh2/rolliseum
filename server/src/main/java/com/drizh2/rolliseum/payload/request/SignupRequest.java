package com.drizh2.rolliseum.payload.request;

import com.drizh2.rolliseum.annotations.PasswordMatches;
import com.drizh2.rolliseum.annotations.ValidEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@PasswordMatches
public class SignupRequest {
    @NotEmpty
    private String username;
    @NotEmpty
    @Email
    @ValidEmail
    private String email;
    @NotEmpty
    @Size(min = 6)
    private String password;
    private String passwordConfirmation;
}
