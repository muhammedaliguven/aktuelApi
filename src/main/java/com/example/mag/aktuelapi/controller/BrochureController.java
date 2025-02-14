package com.example.mag.aktuelapi.controller;

import com.example.mag.aktuelapi.dto.brochure.BrochureDtoRequset;
import com.example.mag.aktuelapi.dto.brochure.BrochureDtoResponse;
import com.example.mag.aktuelapi.dto.brochure.BrochureSummaryDto;
import com.example.mag.aktuelapi.model.Brochure;
import com.example.mag.aktuelapi.repository.UserPushTokenRepository;
import com.example.mag.aktuelapi.service.BrochureService;
import com.example.mag.aktuelapi.service.PushNotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/brochure")
public class BrochureController {

    private final BrochureService brochureService;
    private UserPushTokenRepository tokenRepository;
    private PushNotificationService pushNotificationService;

    public BrochureController(BrochureService brochureService, UserPushTokenRepository tokenRepository, PushNotificationService pushNotificationService) {
        this.brochureService = brochureService;
        this.tokenRepository = tokenRepository;
        this.pushNotificationService = pushNotificationService;
    }


    @GetMapping("/getAll")
    public List<BrochureDtoResponse> getAll() {
        List<BrochureDtoResponse> brochureDtoResponseList = brochureService.findAll();
        return brochureDtoResponseList;
    }


    @GetMapping("/getSummaryByMarkId/{markId}")
    public List<BrochureSummaryDto> getByMarkId(@PathVariable Long markId) {
        return brochureService.getBrochureByMarkId(markId);
    }

    @GetMapping("/getById/{id}")
    public BrochureDtoResponse getById(@PathVariable Long id) {
        BrochureDtoResponse brochureDtoResponse = brochureService.getBrochureId(id);
        return brochureDtoResponse;
    }

    @GetMapping("/getSummaryByIds")
    public List<BrochureDtoResponse> getSummaryByIds(@RequestParam List<Long> ids) {
        return brochureService.getSummaryByIds(ids);
    }

    @PostMapping(value = "/create", consumes = "multipart/form-data")
    public Brochure create(@ModelAttribute BrochureDtoRequset brochureDto) throws Exception {
        Brochure response = brochureService.create(brochureDto);

        // Tüm kullanıcılara bildirim gönder
        List<String> tokens = tokenRepository.findAll()
                .stream()
                .map(a->a.getToken())
                .toList();

        pushNotificationService.sendNotification(
                "Yeni Broşür Yayında!",
                response.getDescription() + " broşürü eklenmiştir. Hemen inceleyin!",
                tokens
        );
        return response;
    }


    @PutMapping(value = "/update/{id}", consumes = "multipart/form-data")
    public Brochure update(@PathVariable Long id, @ModelAttribute BrochureDtoRequset brochureDto) throws IOException {
        return brochureService.update(id, brochureDto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        brochureService.delete(id);
        return new ResponseEntity<>("işlem başarılı", HttpStatus.OK);
    }


}
