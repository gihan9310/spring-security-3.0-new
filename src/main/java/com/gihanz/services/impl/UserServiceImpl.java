package com.gihanz.services.impl;

import com.gihanz.advice.exceptions.RegistrationException;
import com.gihanz.advice.exceptions.UserNotFound401Exception;
import com.gihanz.configs.security.utils.TokenProvider;
import com.gihanz.dtos.LoginDTO;
import com.gihanz.dtos.LoginResponseDTO;
import com.gihanz.dtos.UserDTO;
import com.gihanz.entities.User;
import com.gihanz.repository.RoleRepository;
import com.gihanz.repository.UserRepository;
import com.gihanz.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service(value = "userService")
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, @Lazy BCryptPasswordEncoder passwordEncoder, @Lazy TokenProvider tokenProvider, @Lazy AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @Override
    @Transactional
    public UserDTO registerUser(UserDTO dto) {
        try {
            User entity = dto.getEntity();
            entity.setPassword(passwordEncoder.encode(entity.getPassword()));
            User user = userRepository.save(entity);
            return user.getDTO();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RegistrationException("Can not register user account.");
        }
    }

    @Override
    public LoginResponseDTO login(LoginDTO dto) {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                dto.getUsername(),
                dto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        final String token = tokenProvider.generateToken(authenticate);
        return new LoginResponseDTO(token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFound401Exception {

        User user = userRepository.findByUsername(username);

        if(user==null){
            throw new UserNotFound401Exception("User not found.");
        }
        Set<SimpleGrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRoleCode())).collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
