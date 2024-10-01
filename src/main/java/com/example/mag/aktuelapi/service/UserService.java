package com.example.mag.aktuelapi.service;

import com.example.mag.aktuelapi.dto.UserDto;
import com.example.mag.aktuelapi.model.User;
import com.example.mag.aktuelapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Boolean isPresent(UserDto userDto) {
        Optional<User> user = userRepository.findByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());
        return user.isPresent() ? Boolean.TRUE : Boolean.FALSE;

    }


}
