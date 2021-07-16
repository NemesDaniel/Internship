package com.example.demo.service;

import com.example.demo.dto.RacquetDto;
import com.example.demo.entity.Racquet;
import com.example.demo.mapper.RacquetMapper;
import com.example.demo.repository.RacquetRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RacquetService {

    @Autowired
    private RacquetRepository racquetRepository;

    public Racquet insertRacquet(RacquetDto racquetDto){
        Racquet racquet = RacquetMapper.dtoToEntity(racquetDto);
        return racquetRepository.save(racquet);
    }

}
