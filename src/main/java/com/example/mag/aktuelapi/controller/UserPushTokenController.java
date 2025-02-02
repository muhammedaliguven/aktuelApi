package com.example.mag.aktuelapi.controller;

import com.example.mag.aktuelapi.model.UserPushToken;
import com.example.mag.aktuelapi.repository.UserPushTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/push")
public class UserPushTokenController {

    @Autowired
    private UserPushTokenRepository tokenRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerPushToken(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        tokenRepository.save(new UserPushToken(token));
        return ResponseEntity.ok("Push Token Kaydedildi.");
    }
}
