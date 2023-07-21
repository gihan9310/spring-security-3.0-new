package com.gihanz.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.dtos.main.SuperDTO;
import com.gihanz.entities.Role;
import com.gihanz.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO implements SuperDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String email;
    private Set<Role> roles;

    @JsonIgnore
    public User getEntity(){
        User user = new User();
        BeanUtils.copyProperties(this,user);
        return user;
    }

}
