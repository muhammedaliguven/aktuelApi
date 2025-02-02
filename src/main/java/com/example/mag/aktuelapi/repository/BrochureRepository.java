package com.example.mag.aktuelapi.repository;

import com.example.mag.aktuelapi.dto.brochure.BrochureSummaryDto;
import com.example.mag.aktuelapi.model.Brochure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrochureRepository  extends JpaRepository<Brochure,Long> {


    List<BrochureSummaryDto> findByMarkId(Long markId);

}
