package com.gihanz.services;

import com.gihanz.dtos.LoginDTO;
import com.gihanz.dtos.LoginResponseDTO;
import com.gihanz.dtos.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public UserDTO registerUser(UserDTO dto);
    public LoginResponseDTO login(LoginDTO dto);
}
