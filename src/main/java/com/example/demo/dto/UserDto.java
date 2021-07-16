package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Integer id;

    private String username;

    private String email;

    private String password;

    private String role;

    private Date creationDate;

    @Override
    public String toString(){
        return username + "," + email + "," + password + "," + role + "," + creationDate;
    }
}
