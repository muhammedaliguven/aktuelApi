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
    @Lob
    @Column(name = "pdfData", columnDefinition = "MEDIUMBLOB") // Alanı BLOB olarak tanımlar
    private byte[] pdfData;
    @Column(name = "description")
    private String description;


    public Brochure() {
    }

    public Brochure(Long id, LocalDate startDate, LocalDate endDate, Long markId, byte[] pdfData, String description) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.markId = markId;
        this.pdfData = pdfData;
        this.description = description;
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

    public byte[] getPdfData() {
        return pdfData;
    }

    public void setPdfData(byte[] pdfData) {
        this.pdfData = pdfData;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
