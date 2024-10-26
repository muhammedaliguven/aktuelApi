package com.example.mag.aktuelapi.controller;

import com.example.mag.aktuelapi.dto.brochure.BrochureDtoRequset;
import com.example.mag.aktuelapi.dto.brochure.BrochureDtoResponse;
import com.example.mag.aktuelapi.model.Brochure;
import com.example.mag.aktuelapi.service.BrochureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/getByCategoryId/{categoryId}")
    public List<BrochureDtoResponse> getByCategoryId(@PathVariable Long categoryId) {
        List<BrochureDtoResponse> brochureDtoResponseList = brochureService.getBrochureByCategoryId(categoryId);
        return brochureDtoResponseList;
    }

    @GetMapping("/getByMarkId/{markId}")
    public List<BrochureDtoResponse> getByMarkId(@PathVariable Long markId) {
        List<BrochureDtoResponse> brochureDtoResponseList = brochureService.getBrochureByMarkId(markId);
        return brochureDtoResponseList;
    }

    @PostMapping("/create")
    public Brochure create(@RequestBody BrochureDtoRequset brochureDto) throws Exception {
        Brochure response = brochureService.create(brochureDto);
        return response;
    }

    @PutMapping("/update")
    public Brochure update(@PathVariable Long id, @RequestBody BrochureDtoRequset brochureDto) {
        Brochure response = brochureService.update(id, brochureDto);
        return response;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        brochureService.delete(id);
        return new ResponseEntity<>("işlem başarılı", HttpStatus.OK);
    }


}
