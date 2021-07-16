package com.example.demo.service;

import com.example.demo.dto.ShoeDto;
import com.example.demo.entity.Shoe;
import com.example.demo.mapper.ShoeMapper;
import com.example.demo.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ShoeService {

    @Autowired
    private ShoeRepository shoeRepository;

    public Shoe insertShoe(ShoeDto shoeDto){
        Shoe shoe = ShoeMapper.dtoToEntity(shoeDto);
        return shoeRepository.save(shoe);
    }
}
