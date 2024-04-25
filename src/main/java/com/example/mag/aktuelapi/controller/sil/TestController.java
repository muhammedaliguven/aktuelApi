package com.example.mag.aktuelapi.controller.sil;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("test1")
    public String getImageInfoByName() {
        return "Hello Word";
    }

}
