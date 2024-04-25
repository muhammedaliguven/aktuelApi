package com.example.mag.aktuelapi.controller;

import com.example.mag.aktuelapi.dto.CategoryDto;
import com.example.mag.aktuelapi.model.Category;
import com.example.mag.aktuelapi.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {



    private  final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public List<Category> getBooks() {
        List<Category> categories = categoryService.findAll();
        return categories;
    }

    @PostMapping("/create")
    public Category createBook(@RequestBody CategoryDto categoryDto ) {
        Category response= categoryService.create(categoryDto);
        return response;
    }


}
