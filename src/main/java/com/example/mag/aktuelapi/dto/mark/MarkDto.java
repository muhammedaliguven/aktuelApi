package com.example.mag.aktuelapi.dto.mark;

public class MarkDto {

    private String name;
    private String link;
    private Long categoryId;

    public MarkDto() {
    }

    public MarkDto(String name, String link) {
        this.name = name;
        this.link = link;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }


}
