package com.gihanz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.dtos.UserDTO;
import com.gihanz.entities.main.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User implements SuperEntity {
    @Id
    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "CONTACT_NO")
    private String contactNo;
    @Column(name = "EMAIL",unique = true)
    private String email;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "roleCode",referencedColumnName = "roleCode")
    private Set<Role> roles;

    @JsonIgnore
    public UserDTO getDTO(){
        UserDTO user = new UserDTO();
        BeanUtils.copyProperties(this,user);
        return user;
    }

}
