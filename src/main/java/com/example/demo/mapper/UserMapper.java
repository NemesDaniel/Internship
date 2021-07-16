package com.example.demo.mapper;


import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserMapper {

    public static UserDto entityToDto(User user){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(user, new TypeReference<UserDto>(){});
    }

    public static User dtoToEntity(UserDto userDto){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(userDto, new TypeReference<User>(){});
    }

}
