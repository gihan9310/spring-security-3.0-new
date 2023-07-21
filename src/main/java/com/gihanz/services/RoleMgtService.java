package com.gihanz.services;

import com.gihanz.dtos.RoleDTO;

import java.util.List;

public interface RoleMgtService {

    List<RoleDTO> findAllRoles();

}
