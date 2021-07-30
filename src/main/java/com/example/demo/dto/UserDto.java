package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    @NotEmpty
    @Size(min=3, message = "Your username should have at 3 least characters!")
    private String username;

    @Email
    @NotBlank
    private String email;

    @NotEmpty
    @Size(min=3, message = "Your password should have at 3 least characters!")
    private String password;

    private String role;

    private Date creationDate;

    @Override
    public String toString(){
        return username + "," + email + "," + password + "," + role + "," + creationDate;
    }

    public UserDto(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
