package com.example.mag.aktuelapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "brochure")
public class Brochure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "startDate")
    private LocalDate startDate;
    @Column(name = "endDate")
    private LocalDate endDate;
    @Column(name = "markId")
    private Long markId;
    @Column(name = "categoryId")
    private Long categoryId;;
    @Column(name = "brochureImage")
    private String brochureImage;

    public Brochure() {
    }

    public Brochure(Long id, LocalDate startDate, LocalDate endDate, Long markId, Long categoryId,String brochureImage) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.markId = markId;
        this.categoryId = categoryId;
        this.brochureImage = brochureImage;
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
