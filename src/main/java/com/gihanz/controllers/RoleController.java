package com.gihanz.controllers;

import com.gihanz.dtos.RoleDTO;
import com.gihanz.services.RoleMgtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    private final RoleMgtService roleMgtService;

    public RoleController(RoleMgtService roleMgtService) {
        this.roleMgtService = roleMgtService;
    }

    @GetMapping()
    @PreAuthorize("hasAnyAuthority('ROLE-MGT')")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        return ResponseEntity.ok(roleMgtService.findAllRoles());
    }
}
