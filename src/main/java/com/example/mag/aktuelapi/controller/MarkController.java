package com.example.mag.aktuelapi.controller;

import com.example.mag.aktuelapi.dto.MarkDto;
import com.example.mag.aktuelapi.model.Mark;
import com.example.mag.aktuelapi.service.MarkService;
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

}
