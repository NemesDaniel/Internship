package com.example.demo.mapper;

import com.example.demo.dto.BagDto;
import com.example.demo.dto.BallDto;
import com.example.demo.entity.Bag;
import com.example.demo.entity.Ball;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BallMapper {

    public static BallDto entityToDto(Ball ball){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(ball, new TypeReference<BallDto>(){});
    }

    public static Ball dtoToEntity(BallDto ballDto){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(ballDto, new TypeReference<Ball>(){});
    }

}
