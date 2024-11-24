package com.example.mag.aktuelapi.service;

import com.example.mag.aktuelapi.dto.brochure.BrochureDtoRequset;
import com.example.mag.aktuelapi.dto.brochure.BrochureDtoResponse;
import com.example.mag.aktuelapi.model.Brochure;
import com.example.mag.aktuelapi.model.Mark;
import com.example.mag.aktuelapi.repository.BrochureRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class BrochureService {

    private final BrochureRepository brochureRepository;
    private final MarkService markService;

    public BrochureService(BrochureRepository brochureRepository, MarkService markService) {
        this.brochureRepository = brochureRepository;
        this.markService = markService;
    }


    public List<BrochureDtoResponse> getBrochureByMarkId(Long markId) {
        List<BrochureDtoResponse> brochureDtoResponseList = new ArrayList<>();
        List<Brochure> brochureList = brochureRepository.findByMarkId(markId);
        brochureList.forEach(brochure -> {
            BrochureDtoResponse brochureDtoResponse = new BrochureDtoResponse();
            brochureDtoResponse.setId(brochure.getId());
            brochureDtoResponse.setPdfUrl(brochure.getPdfUrl());
            brochureDtoResponse.setDescription(brochure.getTitle());
            brochureDtoResponseList.add(brochureDtoResponse);
        });
        return brochureDtoResponseList;
    }


    public BrochureDtoResponse getBrochureId(Long id) {
        BrochureDtoResponse brochureDtoResponse = new BrochureDtoResponse();
        Optional<Brochure> brochureOptional = brochureRepository.findById(id);
        if (brochureOptional.isPresent()) {
            brochureDtoResponse.setId(brochureOptional.get().getId());
            brochureDtoResponse.setPdfData(Base64.getEncoder().encodeToString(brochureOptional.get().getPdfData()));
            brochureDtoResponse.setPdfUrl(brochureOptional.get().getPdfUrl());
            brochureDtoResponse.setMarkId(brochureOptional.get().getMarkId());
            brochureDtoResponse.setStartDate(brochureOptional.get().getStartDate());
            brochureDtoResponse.setEndDate(brochureOptional.get().getEndDate());
            brochureDtoResponse.setDescription(brochureOptional.get().getTitle());
        }
        return brochureDtoResponse;
    }

    public List<BrochureDtoResponse> findAll() {
        List<BrochureDtoResponse> brochureDtoResponseList = new ArrayList<>();
        List<Brochure> brochureList = brochureRepository.findAll();

        brochureList.forEach(brochure -> {
            BrochureDtoResponse brochureDtoResponse = new BrochureDtoResponse();
            brochureDtoResponse.setId(brochure.getId());
            brochureDtoResponse.setPdfData(Base64.getEncoder().encodeToString(brochure.getPdfData()));
            brochureDtoResponse.setPdfUrl(brochureDtoResponse.getPdfUrl());
            brochureDtoResponse.setMarkId(brochure.getMarkId());
            brochureDtoResponse.setStartDate(brochure.getStartDate());
            brochureDtoResponse.setEndDate(brochure.getEndDate());
            brochureDtoResponse.setDescription(brochure.getTitle());
            brochureDtoResponseList.add(brochureDtoResponse);
        });
        return brochureDtoResponseList;
    }


    public Brochure create(BrochureDtoRequset brochureDto) throws IOException {
        validateRequest(brochureDto.getMarkId());
        Brochure brochure = new Brochure();
        brochure.setPdfData(brochureDto.getPdfData().getBytes());
        brochure.setMarkId(brochureDto.getMarkId());
        brochure.setStartDate(brochureDto.getStartDate());
        brochure.setEndDate(brochureDto.getEndDate());
        brochure.setTitle(brochureDto.getDescription());
        brochure.setPdfUrl(brochureDto.getPdfUrl());
        brochureRepository.save(brochure);
        return brochure;
    }

    private void validateRequest(Long markId) {
        validateMark(markId);
    }


    private void validateMark(Long markId) {
        Optional<Mark> mark = markService.getMarkId(markId);
        if (!mark.isPresent()) {
            throw new RuntimeException("Mark bulunamadı");
        }
    }

    public Brochure update(Long id, BrochureDtoRequset brochureDto) throws IOException {
        Brochure brochure = brochureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Broşür bulunamadı!"));

        brochure.setStartDate(brochureDto.getStartDate());
        brochure.setEndDate(brochureDto.getEndDate());
        brochure.setMarkId(brochureDto.getMarkId());

        if (brochureDto.getPdfData() != null) {
            brochure.setPdfData(brochureDto.getPdfData().getBytes());
        }

        brochure.setPdfUrl(brochureDto.getPdfUrl());
        brochure.setTitle(brochureDto.getDescription());

        return brochureRepository.save(brochure);
    }

    public void delete(Long id) {
        if (brochureRepository.existsById(id)) {
            brochureRepository.deleteById(id);
        } else {
            throw new RuntimeException("Kayıt bulunamadı");
        }
    }

}
