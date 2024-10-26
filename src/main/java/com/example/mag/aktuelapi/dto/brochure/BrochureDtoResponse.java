package com.example.mag.aktuelapi.dto.brochure;

import java.time.LocalDate;

public class BrochureDtoResponse {


    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long categoryId;
    private Long markId;
    private String brochureImage;

    public BrochureDtoResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getMarkId() {
        return markId;
    }

    public void setMarkId(Long markId) {
        this.markId = markId;
    }


    public String getBrochureImage() {
        return brochureImage;
    }

    public void setBrochureImage(String brochureImage) {
        this.brochureImage = brochureImage;
    }
}
