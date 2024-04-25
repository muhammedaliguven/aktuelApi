package com.example.mag.aktuelapi.repository.sil;

import com.example.mag.aktuelapi.model.sil.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ImageDataRepository extends JpaRepository<ImageData, Long> {
    Optional<ImageData> findByName(String name);
}