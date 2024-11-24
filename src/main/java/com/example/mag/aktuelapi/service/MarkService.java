package com.example.mag.aktuelapi.service;

import com.example.mag.aktuelapi.dto.brochure.BrochureDtoResponse;
import com.example.mag.aktuelapi.dto.mark.MarkDto;
import com.example.mag.aktuelapi.model.Brochure;
import com.example.mag.aktuelapi.model.Category;
import com.example.mag.aktuelapi.model.Mark;
import com.example.mag.aktuelapi.repository.MarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkService {


    private final MarkRepository markRepository;
    private final CategoryService categoryService;

    public MarkService(MarkRepository markRepository, CategoryService categoryService) {
        this.markRepository = markRepository;
        this.categoryService = categoryService;
    }

    public Optional<Mark> getMarkId(Long id) {
        return markRepository.findById(id);
    }

    public List<Mark> getAll() {
        return markRepository.findAll();
    }

    public Mark create(MarkDto dto) {
        validateRequest(dto.getCategoryId());
        Mark mark = new Mark();
        mark.setName(dto.getName());
        mark.setLink(dto.getLink());
        mark.setCategoryId(dto.getCategoryId());
        markRepository.save(mark);
        return mark;
    }

    private void validateRequest(Long categoryId) {
        validateCategory(categoryId);
    }

    private void validateCategory(Long categoryId) {
        Optional<Category> category = categoryService.getCategoryId(categoryId);
        if (!category.isPresent()) {
            throw new RuntimeException("Category bulunamadı");
        }
    }

    public Mark update(Long id, MarkDto dto) {
        return markRepository.findById(id).map(product -> {
            product.setName(dto.getName());
            product.setLink(dto.getLink());
            product.setCategoryId(dto.getCategoryId());
            return markRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Mark not found"));
    }

    public void delete(Long id) {
        if (markRepository.existsById(id)) {
            markRepository.deleteById(id);
        } else {
            throw new RuntimeException("Kayıt bulunamadı");
        }
    }

    public List<Mark> getMarkByCategoryId(Long categoryId) {
        List<Mark> markList = markRepository.findByCategoryId(categoryId);
        return markList;
    }

}
