package com.example.mag.aktuelapi.dto.brochure;


import java.time.LocalDate;

public class BrochureDtoRequset {

    private LocalDate startDate;
    private LocalDate endDate;
    private Long markId;
    private Long categoryId;
    private String brochureImage;

    public BrochureDtoRequset() {
    }

    public BrochureDtoRequset(LocalDate startDate, LocalDate endDate, Long markId, Long categoryId, String brochureImage) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.markId = markId;
        this.categoryId = categoryId;
        this.brochureImage = brochureImage;
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

    public Long getMarkId() {
        return markId;
    }

    public void setMarkId(Long markId) {
        this.markId = markId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getBrochureImage() {
        return brochureImage;
    }

    public void setBrochureImage(String brochureImage) {
        this.brochureImage = brochureImage;
    }
}
