package com.example.mag.aktuelapi.service;

import com.example.mag.aktuelapi.dto.category.CategoryDtoRequest;
import com.example.mag.aktuelapi.dto.category.CategoryDtoResponse;
import com.example.mag.aktuelapi.dto.mark.MarkDtoResponse;
import com.example.mag.aktuelapi.model.Category;
import com.example.mag.aktuelapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final MarkService markService;

    public CategoryService(CategoryRepository categoryRepository, MarkService markService) {
        this.categoryRepository = categoryRepository;
        this.markService = markService;
    }


    public Optional<Category> getCategoryId(Long id) {
        return categoryRepository.findById(id);
    }

    public List<CategoryDtoResponse> getAll() {
        List<CategoryDtoResponse> categoryDtoResponses = new ArrayList<>();
        List<Category> categorieList = categoryRepository.findAll();
        categorieList.forEach(category -> {
            CategoryDtoResponse categoryDtoResponse = new CategoryDtoResponse();
            categoryDtoResponse.setId(category.getId());
            categoryDtoResponse.setName(category.getName());
            categoryDtoResponse.setImage(category.getImage()==null?"": Base64.getEncoder().encodeToString(category.getImage()));
            categoryDtoResponses.add(categoryDtoResponse);
        });
        return categoryDtoResponses;
    }

    public Category create(CategoryDtoRequest dtoRequest) throws IOException {
        Category category = new Category();
        category.setName(dtoRequest.getName());
        category.setImage(dtoRequest.getImage().getBytes());
        categoryRepository.save(category);
        return category;
    }

    public Category update(Long id, CategoryDtoRequest categoryDtoRequest) throws IOException {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(categoryDtoRequest.getName());
        if (categoryDtoRequest.getImage() != null) {
            category.setImage(categoryDtoRequest.getImage().getBytes());
        }
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        if (categoryRepository.existsById(id)) {
            List<MarkDtoResponse> markDtoResponses = markService.getMarkByCategoryId(id);
            if (markDtoResponses.isEmpty()) {
                categoryRepository.deleteById(id);
            } else {
                throw new RuntimeException("Bu category ait marka degerleri oldugu icin category silemezsiniz");
            }
        } else {
            throw new RuntimeException("Kayıt bulunamadı");
        }
    }

}
