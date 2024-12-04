package com.example.mag.aktuelapi.dto.category;


public class CategoryDtoResponse {

    private Long id;
    private String name;
    private String image; // Resim byte[] olarak tutulacak

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
