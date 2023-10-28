package com.drizh2.rolliseum.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String email;
}
