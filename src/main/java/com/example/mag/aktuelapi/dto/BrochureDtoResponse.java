package com.example.mag.aktuelapi.dto;

import java.time.LocalDate;

public class BrochureDtoResponse {


    private LocalDate startDate;
    private LocalDate endDate;
    private MarkDto markDto;
    private CategoryDto categoryDto;
    private String brochureImage;

    public BrochureDtoResponse() {
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public MarkDto getMarkDto() {
        return markDto;
    }

    public void setMarkDto(MarkDto markDto) {
        this.markDto = markDto;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public String getBrochureImage() {
        return brochureImage;
    }

    public void setBrochureImage(String brochureImage) {
        this.brochureImage = brochureImage;
    }
}
