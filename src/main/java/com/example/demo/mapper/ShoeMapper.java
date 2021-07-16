package com.example.demo.mapper;

import com.example.demo.dto.ShoeDto;
import com.example.demo.entity.Shoe;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShoeMapper {

    public static ShoeDto entityToDto(Shoe shoe){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(shoe, new TypeReference<ShoeDto>(){});
    }

    public static Shoe dtoToEntity(ShoeDto shoeDto){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(shoeDto, new TypeReference<Shoe>(){});
    }
}
