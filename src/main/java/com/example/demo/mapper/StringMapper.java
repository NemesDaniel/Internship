package com.example.demo.mapper;

import com.example.demo.dto.StringTDto;
import com.example.demo.entity.StringT;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StringMapper {

    public static StringTDto entityToDto(StringT stringT){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(stringT, new TypeReference<StringTDto>(){});
    }

    public static StringT dtoToEntity(StringTDto stringTDto){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(stringTDto, new TypeReference<StringT>(){});
    }

}
