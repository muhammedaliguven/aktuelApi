package com.example.mag.aktuelapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_push_tokens")
public class UserPushToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;  // Expo Push Token

    public UserPushToken() {

    }

    public UserPushToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
