package com.example.mag.aktuelapi.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class PushNotificationService {

    private static final String EXPO_PUSH_API = "https://exp.host/--/api/v2/push/send";

    public void sendNotification(String title, String message, List<String> tokens) {
        if (tokens.isEmpty()) return;

        RestTemplate restTemplate = new RestTemplate();
        List<Map<String, Object>> pushRequests = new ArrayList<>();

        for (String token : tokens) {
            Map<String, Object> pushMessage = new HashMap<>();
            pushMessage.put("to", token);
            pushMessage.put("title", title);
            pushMessage.put("body", message);
            pushRequests.add(pushMessage);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<Map<String, Object>>> request = new HttpEntity<>(pushRequests, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(EXPO_PUSH_API, request, String.class);
        System.out.println("Push Notification Response: " + response.getBody());
    }
}
