package com.gihanz.services.impl;

import com.gihanz.advice.exceptions.BandRequest400Exception;
import com.gihanz.dtos.RoleDTO;
import com.gihanz.entities.Role;
import com.gihanz.repository.RoleRepository;
import com.gihanz.services.RoleMgtService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleMgtServiceImpl implements RoleMgtService {

    private final RoleRepository roleRepository;

    public RoleMgtServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDTO> findAllRoles() {
        try {
            List<Role> all = roleRepository.findAll();
            return all.stream().map(Role::getDTO).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BandRequest400Exception(e.getMessage());
        }
    }
}
