package com.example.demo.service;

import com.example.demo.dto.BallDto;
import com.example.demo.entity.Ball;
import com.example.demo.mapper.BallMapper;
import com.example.demo.repository.BallRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BallService {

    @Autowired
    private BallRepository ballRepository;

    public Ball insertBall(BallDto ballDto){
        Ball ball = BallMapper.dtoToEntity(ballDto);
        return ballRepository.save(ball);
    }
}
