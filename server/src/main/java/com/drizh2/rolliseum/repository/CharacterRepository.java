package com.drizh2.rolliseum.repository;

import com.drizh2.rolliseum.entity.Character;
import com.drizh2.rolliseum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    Optional<Character> findCharacterById(Long id);
    Optional<Character> findCharacterByName(String name);
    List<Character> findAllByUserOrderByCreationDateDesc(User user);
}
