package com.gihanz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.dtos.RoleDTO;
import com.gihanz.entities.main.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Role implements SuperEntity {
    @Id
    @Column(name = "ROLE_CODE")
    private String RoleCode;
    @Column(name = "ROLE_NAME")
    private String roleName;

    @JsonIgnore
    public RoleDTO getDTO(){
        RoleDTO dto = new RoleDTO();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}
