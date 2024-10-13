package com.example.mag.aktuelapi.service;

import com.example.mag.aktuelapi.dto.category.CategoryDto;
import com.example.mag.aktuelapi.model.Category;
import com.example.mag.aktuelapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category getCategoryId(Long id) throws Exception {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        } else {
            throw new Exception("Id ye ait  bir category bulunamadı");
        }
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category create(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setLink(categoryDto.getLink());
        categoryRepository.save(category);
        return category;
    }

    public Category update(Long id, CategoryDto dto) {
        return categoryRepository.findById(id).map(product -> {
            product.setName(dto.getName());
            product.setLink(dto.getLink());
            return categoryRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Mark not found"));
    }

    public void delete(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Kayıt bulunamadı");
        }
    }

}
