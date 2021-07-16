package com.example.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuratie {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}