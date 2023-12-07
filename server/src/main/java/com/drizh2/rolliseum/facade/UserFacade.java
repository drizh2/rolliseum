package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.UserDTO;
import com.drizh2.rolliseum.entity.User;

public class UserFacade {

    private UserFacade() {}

    public static UserDTO userToUserDTO(User user) {
        return UserDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    public static User userDTOToUser(UserDTO userDTO) {
        return User.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .build();
    }
}
