package com.drizh2.rolliseum.service;

import com.drizh2.rolliseum.entity.User;
import com.drizh2.rolliseum.entity.enums.Roles;
import com.drizh2.rolliseum.exception.UserExistsException;
import com.drizh2.rolliseum.payload.request.SignupRequest;
import com.drizh2.rolliseum.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final MailSender mailSender;

    @Autowired
    private CustomPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, MailSender mailSender) {
        this.userRepository = userRepository;
        this.mailSender = mailSender;
    }

    public boolean createUser(SignupRequest request) {
        User user = new User();

        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.getPasswordEncoder().encode(request.getPassword()));
        user.getRoles().add(Roles.ROLE_USER);
        user.setActivationCode(UUID.randomUUID().toString());

        try {
            LOG.info("Creating new user with email: {}", user.getEmail());
            userRepository.save(user);
            if (StringUtils.hasText(user.getEmail())) {
                String message = String.format(
                        "Hello, %s! \n" +
                                "Welcome to Rolliseum! \n" +
                                "To activate your account you should visit this link: http://localhost:8080/api/auth/activate/%s",
                        user.getUsername(), user.getActivationCode()
                );
                mailSender.sendMessage(user.getEmail(), "Activation Code", message);
            }
            return true;
        } catch (Exception e) {
            LOG.error("Error while creating user with email: {}", user.getEmail());
            throw new UserExistsException("User is already exists!");
        }
    }

    public boolean activateUser(String code) {
        User user = userRepository.findUserByActivationCode(code).orElse(null);

        if (user == null) {
            return false;
        }

        user.setActivationCode(null);
        userRepository.save(user);

        return true;
    }
}
