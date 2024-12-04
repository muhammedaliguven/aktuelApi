package com.example.mag.aktuelapi.controller;

import com.example.mag.aktuelapi.dto.mark.MarkDtoRequest;
import com.example.mag.aktuelapi.dto.mark.MarkDtoResponse;
import com.example.mag.aktuelapi.model.Mark;
import com.example.mag.aktuelapi.service.MarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/mark")
public class MarkController {

    private final MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @GetMapping("/getAll")
    public List<MarkDtoResponse> getAll() {
        return markService.getAll();
    }

    @PostMapping(value = "/create", consumes = "multipart/form-data")
    public Mark create(@ModelAttribute MarkDtoRequest markDto) throws Exception {
        return markService.create(markDto);
    }

    @PutMapping(value = "/update/{id}", consumes = "multipart/form-data")
    public Mark update(@PathVariable Long id, @ModelAttribute MarkDtoRequest markDto) throws IOException {
        return markService.update(id, markDto);
    }

    @GetMapping("/getByCategoryId/{categoryId}")
    public List<MarkDtoResponse> getByCategoryId(@PathVariable Long categoryId) {
        return markService.getMarkByCategoryId(categoryId);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        markService.delete(id);
        return new ResponseEntity<>("Mark deleted successfully.", HttpStatus.OK);
    }

}