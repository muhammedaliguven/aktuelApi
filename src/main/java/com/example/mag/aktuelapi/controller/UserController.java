package com.example.mag.aktuelapi.controller;

import com.example.mag.aktuelapi.dto.UserDto;
import com.example.mag.aktuelapi.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

  //todo get metoda cevir
    @PostMapping("/isPresent")
    public Boolean getBooks(@RequestBody UserDto userDto) {
        return userService.isPresent(userDto);
    }
}
