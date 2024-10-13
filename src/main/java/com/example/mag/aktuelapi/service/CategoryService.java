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
        throw  new Exception("Id ye ait  bir category bulunamadı");
        }
    }


    public List<Category> findAll() {
        return categoryRepository.findAll();
    }



    public Category create(CategoryDto categoryDto) {
        Category category=new Category();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return category;
    }



}
