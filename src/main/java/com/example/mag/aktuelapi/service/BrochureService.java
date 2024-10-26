package com.example.mag.aktuelapi.service;

import com.example.mag.aktuelapi.dto.brochure.BrochureDtoRequset;
import com.example.mag.aktuelapi.dto.brochure.BrochureDtoResponse;
import com.example.mag.aktuelapi.dto.category.CategoryDto;
import com.example.mag.aktuelapi.dto.mark.MarkDto;
import com.example.mag.aktuelapi.model.Brochure;
import com.example.mag.aktuelapi.model.Category;
import com.example.mag.aktuelapi.model.Mark;
import com.example.mag.aktuelapi.repository.BrochureRepository;
import com.example.mag.aktuelapi.repository.MarkRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrochureService {

    private final BrochureRepository brochureRepository;
    private final CategoryService categoryService;
    private final MarkService markService;
    private final MarkRepository markRepository;

    public BrochureService(BrochureRepository brochureRepository, CategoryService categoryService, MarkService markService, MarkRepository markRepository) {
        this.brochureRepository = brochureRepository;
        this.categoryService = categoryService;
        this.markService = markService;
        this.markRepository = markRepository;
    }

    public List<BrochureDtoResponse> getBrochureByCategoryId(Long categoryId) {
        List<BrochureDtoResponse> brochureDtoResponseList = new ArrayList<>();
        List<Brochure> brochureList = brochureRepository.findByCategoryId(categoryId);
        brochureList.forEach(brochure -> {
            BrochureDtoResponse brochureDtoResponse = new BrochureDtoResponse();
            brochureDtoResponse.setId(brochure.getId());
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
            brochureDtoResponse.setId(brochure.getId());
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
            brochureDtoResponse.setId(brochure.getId());
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
        List<Mark> markList = markService.getAll();
        MarkDto markDto = markList.stream().filter(category -> category.getId().equals(markId)).findFirst().map(mark -> new MarkDto(mark.getName(), mark.getLink())).get();
        return markDto;
    }


    public Brochure create(BrochureDtoRequset brochureDto)  {
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

    //todo
    private void validateRequest(Long categoryId, Long markId) {
        validateCategory(categoryId);
        validateMark(markId);
    }

    private void validateCategory(Long categoryId){
        Optional<Category> category= categoryService.getCategoryId(categoryId);
        if(!category.isPresent()){
            throw new RuntimeException("Category bulunamadı");
        }
    }
    private void validateMark(Long markId){
        Optional<Mark> mark= markService.getMarkId(markId);
        if(!mark.isPresent()){
            throw new RuntimeException("Mark bulunamadı");
        }
    }

    public Brochure update(Long id, BrochureDtoRequset dto) {
        return brochureRepository.findById(id).map(brochure -> {
            brochure.setBrochureImage(dto.getBrochureImage());
            brochure.setCategoryId(dto.getCategoryId());
            brochure.setMarkId(dto.getMarkId());
            brochure.setEndDate(dto.getEndDate());
            brochure.setStartDate(dto.getStartDate());
            return brochureRepository.save(brochure);
        }).orElseThrow(() -> new RuntimeException("Brochure not found"));
    }

    public void delete(Long id) {
        if (brochureRepository.existsById(id)) {
            brochureRepository.deleteById(id);
        } else {
            throw new RuntimeException("Kayıt bulunamadı");
        }
    }

}
