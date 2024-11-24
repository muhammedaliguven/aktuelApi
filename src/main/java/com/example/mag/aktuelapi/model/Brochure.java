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
    @Column(name = "pdfUrl")
    private String pdfUrl;
    @Column(name = "description")
    private String title;


    public Brochure() {
    }

    public Brochure(Long id, LocalDate startDate, LocalDate endDate, Long markId, byte[] pdfData, String pdfUrl, String title) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.markId = markId;
        this.pdfData = pdfData;
        this.pdfUrl = pdfUrl;
        this.title = title;
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

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String description) {
        this.title = description;
    }


}
