package com.example.mag.aktuelapi.dto.sil;

public class ImageUploadResponse {


    private String originalFilename;

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public ImageUploadResponse(String originalFilename) {
        this.originalFilename = originalFilename;
    }

}
