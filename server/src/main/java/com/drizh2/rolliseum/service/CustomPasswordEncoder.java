package com.drizh2.rolliseum.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomPasswordEncoder {
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}
