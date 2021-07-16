package com.example.demo.mapper;

import com.example.demo.dto.BagDto;
import com.example.demo.entity.Bag;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BagMapper {

    public static BagDto entityToDto(Bag bag){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(bag, new TypeReference<BagDto>(){});
    }

    public static Bag dtoToEntity(BagDto bagDto){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(bagDto, new TypeReference<Bag>(){});
    }
}
