package com.gihanz.dtos;

import com.gihanz.dtos.main.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LoginDTO implements SuperDTO {

    private String username;
    private String password;
}
