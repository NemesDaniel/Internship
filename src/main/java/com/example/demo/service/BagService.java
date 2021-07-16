package com.example.demo.service;

import com.example.demo.dto.BagDto;
import com.example.demo.entity.Bag;
import com.example.demo.mapper.BagMapper;
import com.example.demo.repository.BagRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BagService {

    @Autowired
    private BagRepository bagRepository;

    public Bag insertBag(BagDto bagDto){
        Bag bag = BagMapper.dtoToEntity(bagDto);
        return bagRepository.save(bag);
    }

}
