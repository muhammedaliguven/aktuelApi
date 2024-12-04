package com.example.mag.aktuelapi.controller;

import com.example.mag.aktuelapi.dto.brochure.BrochureDtoRequset;
import com.example.mag.aktuelapi.dto.brochure.BrochureDtoResponse;
import com.example.mag.aktuelapi.model.Brochure;
import com.example.mag.aktuelapi.service.BrochureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/brochure")
public class BrochureController {

    private final BrochureService brochureService;


    public BrochureController(BrochureService brochureService) {
        this.brochureService = brochureService;
    }


    @GetMapping("/getAll")
    public List<BrochureDtoResponse> getAll() {
        List<BrochureDtoResponse> brochureDtoResponseList = brochureService.findAll();
        return brochureDtoResponseList;
    }


    @GetMapping("/getByMarkId/{markId}")
    public List<BrochureDtoResponse> getByMarkId(@PathVariable Long markId) {
        List<BrochureDtoResponse> brochureDtoResponseList = brochureService.getBrochureByMarkId(markId);
        return brochureDtoResponseList;
    }

    @GetMapping("/getById/{id}")
    public BrochureDtoResponse getById(@PathVariable Long id) {
        BrochureDtoResponse brochureDtoResponse = brochureService.getBrochureId(id);
        return brochureDtoResponse;
    }

    @PostMapping(value="/create",consumes = "multipart/form-data")
    public Brochure create(@ModelAttribute BrochureDtoRequset brochureDto) throws Exception {
        Brochure response = brochureService.create(brochureDto);
        return response;
    }


    @PutMapping(value="/update/{id}",consumes = "multipart/form-data")
    public Brochure update(@PathVariable Long id, @ModelAttribute BrochureDtoRequset brochureDto) throws IOException {
        return brochureService.update(id, brochureDto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        brochureService.delete(id);
        return new ResponseEntity<>("işlem başarılı", HttpStatus.OK);
    }


}
