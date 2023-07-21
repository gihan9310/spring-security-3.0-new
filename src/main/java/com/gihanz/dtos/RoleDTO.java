package com.gihanz.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.entities.Role;
import com.gihanz.entities.main.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RoleDTO implements SuperEntity {

    private String RoleCode;
    private String roleName;

    @JsonIgnore
    public Role getEntity(){
        Role role = new Role();
        BeanUtils.copyProperties(this,role);
        return role;
    }

}
