package com.drizh2.rolliseum.repository;

import com.drizh2.rolliseum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    Optional<User> findUserById(Long id);

    Optional<User> findUserByEmail(String email);
}
