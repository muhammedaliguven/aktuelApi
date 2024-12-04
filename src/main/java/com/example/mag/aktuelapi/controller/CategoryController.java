package com.example.mag.aktuelapi.controller;

import com.example.mag.aktuelapi.dto.category.CategoryDtoRequest;
import com.example.mag.aktuelapi.dto.category.CategoryDtoResponse;
import com.example.mag.aktuelapi.model.Category;
import com.example.mag.aktuelapi.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public List<CategoryDtoResponse> getBooks() {
        return categoryService.getAll();
    }

    @PostMapping(value = "/create", consumes = "multipart/form-data")
    public Category create(@ModelAttribute CategoryDtoRequest categoryDtoRequest) throws Exception {
        return categoryService.create(categoryDtoRequest);
    }

    @PutMapping(value = "/update/{id}", consumes = "multipart/form-data")
    public Category update(@PathVariable Long id, @ModelAttribute CategoryDtoRequest markDto) throws IOException {
        return categoryService.update(id, markDto);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
