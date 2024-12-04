package com.example.mag.aktuelapi.dto.category;

import org.springframework.web.multipart.MultipartFile;

public class CategoryDtoRequest {


    private String name;
    private MultipartFile image; // Resim byte[] olarak tutulacak

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
}
