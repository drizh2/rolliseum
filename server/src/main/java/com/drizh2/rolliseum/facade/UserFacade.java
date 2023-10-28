package com.drizh2.rolliseum.facade;

import com.drizh2.rolliseum.dto.UserDTO;
import com.drizh2.rolliseum.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {
    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }
}
