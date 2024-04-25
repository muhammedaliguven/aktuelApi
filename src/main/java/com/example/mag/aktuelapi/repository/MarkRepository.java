package com.example.mag.aktuelapi.repository;

import com.example.mag.aktuelapi.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository  extends JpaRepository<Mark,Long> {
}
