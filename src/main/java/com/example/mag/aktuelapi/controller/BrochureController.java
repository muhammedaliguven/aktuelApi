package com.example.mag.aktuelapi.controller;

import com.example.mag.aktuelapi.dto.BrochureDtoRequset;
import com.example.mag.aktuelapi.dto.BrochureDtoResponse;
import com.example.mag.aktuelapi.model.Brochure;
import com.example.mag.aktuelapi.service.BrochureService;
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
    public List<BrochureDtoResponse> getBrochure() {
        List<BrochureDtoResponse> brochureDtoResponseList = brochureService.findAll();
        return brochureDtoResponseList;
    }


    @GetMapping("/getByCategoryId/{categoryId}")
    public List<BrochureDtoResponse> getBrochureByCategoryId(@PathVariable Long categoryId) {
        List<BrochureDtoResponse> brochureDtoResponseList = brochureService.getBrochureByCategoryId(categoryId);
        return brochureDtoResponseList;
    }

    @GetMapping("/getByMarkId/{markId}")
    public List<BrochureDtoResponse> getBrochureByMarkId(@PathVariable Long markId) {
        List<BrochureDtoResponse> brochureDtoResponseList = brochureService.getBrochureByMarkId(markId);
        return brochureDtoResponseList;
    }

    @PostMapping("/create")
    public Brochure createBrochure(@RequestBody BrochureDtoRequset brochureDto ) throws Exception {
        Brochure response= brochureService.create(brochureDto);
        return response;
    }

}
