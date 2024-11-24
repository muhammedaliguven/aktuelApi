package com.example.mag.aktuelapi.controller;

import com.example.mag.aktuelapi.dto.mark.MarkDto;
import com.example.mag.aktuelapi.model.Mark;
import com.example.mag.aktuelapi.service.MarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mark")
public class MarkController {

    private final MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @GetMapping("/getAll")
    public List<Mark> getAll() {
        return markService.getAll();
    }

    @PostMapping("/create")
    public Mark create(@RequestBody MarkDto dto) {
        return markService.create(dto);
    }

    @PutMapping("update/{id}")
    public Mark update(@PathVariable Long id, @RequestBody MarkDto dto) {
        return markService.update(id, dto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        markService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getByCategoryId/{categoryId}")
    public List<Mark> getByCategoryId(@PathVariable Long categoryId) {
        List<Mark> markList = markService.getMarkByCategoryId(categoryId);
        return markList;
    }

}
