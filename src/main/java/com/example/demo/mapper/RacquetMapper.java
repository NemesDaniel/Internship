package com.example.demo.mapper;

import com.example.demo.dto.RacquetDto;
import com.example.demo.entity.Racquet;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RacquetMapper {
    public static RacquetDto entityToDto(Racquet racquet){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(racquet, new TypeReference<RacquetDto>(){});
    }

    public static Racquet dtoToEntity(RacquetDto racquetDto){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(racquetDto, new TypeReference<Racquet>(){});
    }
}
