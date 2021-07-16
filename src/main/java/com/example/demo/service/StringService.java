package com.example.demo.service;

import com.example.demo.dto.StringTDto;
import com.example.demo.entity.StringT;
import com.example.demo.mapper.StringMapper;
import com.example.demo.repository.StringRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StringService {


    @Autowired
    private StringRepository stringRepository;

    public StringT insertString(StringTDto stringTDto){
        StringT stringT = StringMapper.dtoToEntity(stringTDto);
        return stringRepository.save(stringT);
    }
}
