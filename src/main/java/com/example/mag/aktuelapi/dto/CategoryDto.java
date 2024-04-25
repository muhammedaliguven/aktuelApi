package com.example.mag.aktuelapi.dto;

public class CategoryDto {


    private String name;
    private String link;


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDto() {
    }

    public CategoryDto(String name, String link) {
        this.name = name;
        this.link = link;
    }

}
