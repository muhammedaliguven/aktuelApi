package com.example.mag.aktuelapi.dto.mark;

import org.springframework.web.multipart.MultipartFile;

public class MarkDtoRequest {

    private String name;
    private MultipartFile image;
    private Long categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
