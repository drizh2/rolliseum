package com.drizh2.rolliseum.repository;

import com.drizh2.rolliseum.entity.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    Optional<ImageModel> findImageModelByUserId(Long userID);

    Optional<ImageModel> findImageModelByName(String name);
}
