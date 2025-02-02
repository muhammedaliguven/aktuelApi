package com.example.mag.aktuelapi.repository;

import com.example.mag.aktuelapi.model.UserPushToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPushTokenRepository extends JpaRepository<UserPushToken, Long> {
}
