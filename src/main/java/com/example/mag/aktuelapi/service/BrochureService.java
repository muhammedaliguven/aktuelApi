package com.example.mag.aktuelapi.service;

import com.example.mag.aktuelapi.dto.BrochureDtoRequset;
import com.example.mag.aktuelapi.dto.BrochureDtoResponse;
import com.example.mag.aktuelapi.dto.CategoryDto;
import com.example.mag.aktuelapi.dto.MarkDto;
import com.example.mag.aktuelapi.model.Brochure;
import com.example.mag.aktuelapi.model.Category;
import com.example.mag.aktuelapi.model.Mark;
import com.example.mag.aktuelapi.repository.BrochureRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrochureService {

    private final BrochureRepository brochureRepository;
    private final CategoryService categoryService;
    private final MarkService markService;

    public BrochureService(BrochureRepository brochureRepository, CategoryService categoryService, MarkService markService) {
        this.brochureRepository = brochureRepository;
        this.categoryService = categoryService;
        this.markService = markService;
    }

    public List<BrochureDtoResponse> getBrochureByCategoryId(Long categoryId) {
        List<BrochureDtoResponse> brochureDtoResponseList = new ArrayList<>();
        List<Brochure> brochureList = brochureRepository.findByCategoryId(categoryId);
        brochureList.forEach(brochure -> {
            BrochureDtoResponse brochureDtoResponse = new BrochureDtoResponse();
            brochureDtoResponse.setBrochureImage(brochure.getBrochureImage());
            brochureDtoResponse.setCategoryDto(getCategoryDtoById(brochure.getCategoryId()));
            brochureDtoResponse.setMarkDto(getMarkDtoById(brochure.getMarkId()));
            brochureDtoResponse.setStartDate(brochure.getStartDate());
            brochureDtoResponse.setEndDate(brochure.getEndDate());
            brochureDtoResponseList.add(brochureDtoResponse);
        });
        return brochureDtoResponseList;
    }

    public List<BrochureDtoResponse> getBrochureByMarkId(Long markId) {
        List<BrochureDtoResponse> brochureDtoResponseList = new ArrayList<>();
        List<Brochure> brochureList = brochureRepository.findByMarkId(markId);
        brochureList.forEach(brochure -> {
            BrochureDtoResponse brochureDtoResponse = new BrochureDtoResponse();
            brochureDtoResponse.setBrochureImage(brochure.getBrochureImage());
            brochureDtoResponse.setCategoryDto(getCategoryDtoById(brochure.getCategoryId()));
            brochureDtoResponse.setMarkDto(getMarkDtoById(brochure.getMarkId()));
            brochureDtoResponse.setStartDate(brochure.getStartDate());
            brochureDtoResponse.setEndDate(brochure.getEndDate());
            brochureDtoResponseList.add(brochureDtoResponse);
        });
        return brochureDtoResponseList;
    }

    public List<BrochureDtoResponse> findAll() {
        List<BrochureDtoResponse> brochureDtoResponseList = new ArrayList<>();
        List<Brochure> brochureList = brochureRepository.findAll();

        brochureList.forEach(brochure -> {
            BrochureDtoResponse brochureDtoResponse = new BrochureDtoResponse();
            brochureDtoResponse.setBrochureImage(brochure.getBrochureImage());
            brochureDtoResponse.setCategoryDto(getCategoryDtoById(brochure.getCategoryId()));
            brochureDtoResponse.setMarkDto(getMarkDtoById(brochure.getMarkId()));
            brochureDtoResponse.setStartDate(brochure.getStartDate());
            brochureDtoResponse.setEndDate(brochure.getEndDate());
            brochureDtoResponseList.add(brochureDtoResponse);
        });
        return brochureDtoResponseList;
    }


    public CategoryDto getCategoryDtoById(Long categoryId) {
        List<Category> categoryList = categoryService.findAll();
        CategoryDto categoryDto = categoryList.stream().filter(category -> category.getId().equals(categoryId)).findFirst().map(category -> new CategoryDto(category.getName(), category.getLink())).get();
        return categoryDto;
    }


    public MarkDto getMarkDtoById(Long markId) {
        List<Mark> markList = markService.findAll();
        MarkDto markDto = markList.stream().filter(category -> category.getId().equals(markId)).findFirst().map(mark -> new MarkDto(mark.getName(), mark.getLink())).get();
        return markDto;
    }


    public Brochure create(BrochureDtoRequset brochureDto) throws Exception {
        validateRequest(brochureDto.getCategoryId(), brochureDto.getMarkId());
        Brochure brochure = new Brochure();
        brochure.setBrochureImage(brochureDto.getBrochureImage());
        brochure.setCategoryId(brochureDto.getCategoryId());
        brochure.setMarkId(brochureDto.getMarkId());
        brochure.setStartDate(brochureDto.getStartDate());
        brochure.setEndDate(brochureDto.getEndDate());
        brochureRepository.save(brochure);
        return brochure;
    }

    private void validateRequest(Long categoryId, Long markId) throws Exception {
        categoryService.getCategoryId(categoryId);
        markService.getMarkId(markId);
    }


}
