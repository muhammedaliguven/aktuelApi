package com.example.mag.aktuelapi.service.sil;

import com.example.mag.aktuelapi.dto.sil.ImageUploadResponse;
import com.example.mag.aktuelapi.model.sil.ImageData;
import com.example.mag.aktuelapi.repository.sil.ImageDataRepository;
import com.example.mag.aktuelapi.util.ImageUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageDataService {

    @Autowired
    private ImageDataRepository imageDataRepository;

    public ImageUploadResponse uploadImage(MultipartFile file) throws IOException {

        imageDataRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes())).build());

        return new ImageUploadResponse("Image uploaded successfully: " + file.getOriginalFilename());

    }

    @Transactional
    public ImageData getInfoByImageByName(String name) {
        Optional<ImageData> dbImage = imageDataRepository.findByName(name);

        return ImageData.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .imageData(ImageUtil.decompressImage(dbImage.get().getImageData())).build();

    }

    @Transactional
    public byte[] getImage(String name) {
        Optional<ImageData> dbImage = imageDataRepository.findByName(name);
        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
        return image;
    }


}