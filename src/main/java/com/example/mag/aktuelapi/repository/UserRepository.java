package com.example.mag.aktuelapi.repository;

import com.example.mag.aktuelapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {

    Optional<User> findByUsernameAndPassword(String name,String password);

}
