package com.example.mag.aktuelapi.dto.brochure;


import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class BrochureDtoRequset {

    private LocalDate startDate;
    private LocalDate endDate;
    private Long markId;
    private MultipartFile pdfData;
    private String pdfUrl;
    private String description;

    // Getter ve Setter'lar
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

    public MultipartFile getPdfData() {
        return pdfData;
    }

    public void setPdfData(MultipartFile pdfData) {
        this.pdfData = pdfData;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}