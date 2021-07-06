package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @Value("${spring.datasource.username}")
    private String datasource;

    @GetMapping("/app")
    public String dataSource(){
        System.out.println(datasource);
        return datasource;
    }

    @Bean
    public String getDatasource(){
        return datasource;
    }


}
