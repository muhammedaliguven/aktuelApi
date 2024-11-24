package com.example.mag.aktuelapi.repository;

import com.example.mag.aktuelapi.model.Brochure;
import com.example.mag.aktuelapi.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository  extends JpaRepository<Mark,Long> {
    List<Mark> findByCategoryId(Long categoryId);

}
