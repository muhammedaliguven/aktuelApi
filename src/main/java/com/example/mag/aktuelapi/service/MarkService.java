package com.example.mag.aktuelapi.service;

import com.example.mag.aktuelapi.dto.brochure.BrochureDtoResponse;
import com.example.mag.aktuelapi.dto.brochure.BrochureSummaryDto;
import com.example.mag.aktuelapi.dto.mark.MarkDtoRequest;
import com.example.mag.aktuelapi.dto.mark.MarkDtoResponse;
import com.example.mag.aktuelapi.model.Mark;
import com.example.mag.aktuelapi.repository.MarkRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class MarkService {


    private final MarkRepository markRepository;
    private final BrochureService brochureService;

    public MarkService(MarkRepository markRepository, BrochureService brochureService) {
        this.markRepository = markRepository;
        this.brochureService = brochureService;
    }

    public Optional<Mark> getMarkId(Long id) {
        return markRepository.findById(id);
    }

    public List<MarkDtoResponse> getAll() {
        List<MarkDtoResponse> markDtoListResponse = new ArrayList<>();
        List<Mark> markList = markRepository.findAll();
        markList.forEach(mark -> {
            MarkDtoResponse markDtoResponse = new MarkDtoResponse();
            markDtoResponse.setId(mark.getId());
            markDtoResponse.setName(mark.getName());
            markDtoResponse.setCategoryId(mark.getCategoryId());
            markDtoResponse.setImage(mark.getImage() == null ? "" : Base64.getEncoder().encodeToString(mark.getImage()));
            markDtoListResponse.add(markDtoResponse);
        });
        return markDtoListResponse;
    }

    public Mark create(MarkDtoRequest dto) throws IOException {
   //     validateRequest(dto.getCategoryId());
        Mark mark = new Mark();
        mark.setName(dto.getName());
        mark.setImage(dto.getImage().getBytes());
        mark.setCategoryId(dto.getCategoryId());
        markRepository.save(mark);
        return mark;
    }
/*
    private void validateRequest(Long categoryId) {
       validateCategory(categoryId);
    }

    private void validateCategory(Long categoryId) {
        Optional<Category> category = categoryService.getCategoryId(categoryId);
        if (!category.isPresent()) {
            throw new RuntimeException("Category bulunamadı");
        }
    }

 */

    public Mark update(Long id, MarkDtoRequest markDto) throws IOException {
        Mark mark = markRepository.findById(id).orElseThrow(() -> new RuntimeException("Mark not found"));
        mark.setName(markDto.getName());
        mark.setCategoryId(markDto.getCategoryId());
        if (markDto.getImage() != null) {
            mark.setImage(markDto.getImage().getBytes());
        }
        return markRepository.save(mark);
    }

    public void delete(Long id) {
        if (markRepository.existsById(id)) {
            List<BrochureSummaryDto> brochureDtoResponseList = brochureService.getBrochureByMarkId(id);
            if (brochureDtoResponseList.isEmpty()) {
                markRepository.deleteById(id);
            } else {
                throw new RuntimeException("Bu markaya ait brosür degerleri oldugu icin silemezsiniz");
            }
        } else {
            throw new RuntimeException("Kayıt bulunamadı");
        }
    }

    public List<MarkDtoResponse> getMarkByCategoryId(Long categoryId) {
        List<MarkDtoResponse> markDtoList = new ArrayList<>();
        List<Mark> markList = markRepository.findByCategoryId(categoryId);
        markList.forEach(mark -> {
            MarkDtoResponse markDto = new MarkDtoResponse();
            markDto.setId(mark.getId());
            markDto.setName(mark.getName());
            markDto.setCategoryId(mark.getCategoryId());
            markDto.setImage(Base64.getEncoder().encodeToString(mark.getImage()));
            markDtoList.add(markDto);
        });
        return markDtoList;
    }

}
