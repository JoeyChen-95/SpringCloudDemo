package net.biancheng.c.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private String realName;
    private String address;
    private String email;
}
