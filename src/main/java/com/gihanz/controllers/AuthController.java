package com.gihanz.controllers;

import com.gihanz.dtos.LoginDTO;
import com.gihanz.dtos.LoginResponseDTO;
import com.gihanz.dtos.UserDTO;
import com.gihanz.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final UserService  userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> registration(@RequestBody UserDTO dto){
        UserDTO user = userService.registerUser(dto);
       return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO dto){
        LoginResponseDTO token = userService.login(dto);
        return ResponseEntity.ok(token);
    }
}
