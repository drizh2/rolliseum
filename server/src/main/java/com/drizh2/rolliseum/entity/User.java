package com.drizh2.rolliseum.entity;

import com.drizh2.rolliseum.entity.enums.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.*;

@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private List<Character> characters = new ArrayList<>();
    private LocalDateTime creationDate;

    private Set<Roles> roles = new HashSet<>();

    private Collection<? extends GrantedAuthority> authorities;

    protected void onCreate() {
        this.creationDate = LocalDateTime.now();
    }

    public User() {
    }

    public User(Long id, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
}
