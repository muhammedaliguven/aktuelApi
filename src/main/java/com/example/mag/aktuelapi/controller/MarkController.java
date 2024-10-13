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

    private  final MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @GetMapping("/getAll")
    public List<Mark> getMarks() {
        List<Mark> marks = markService.findAll();
        return marks;
    }

    @PostMapping("/create")
    public Mark createMark(@RequestBody MarkDto markDto ) {
        Mark response= markService.create(markDto);
        return response;
    }

    @PutMapping("/{id}")
    public Mark updateMark(@PathVariable Long id, @RequestBody Mark dto ) {
        Mark response= markService.updateMark(id,dto);
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMark(@PathVariable Long id) {
        markService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
