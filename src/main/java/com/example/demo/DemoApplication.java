package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

@SpringBootApplication
//@ImportResource("classpath:C:/Program Files/apache-maven-3.8.1/conf/settings.xml")
public class DemoApplication {


    public static void main(String[] args) throws IOException, URISyntaxException {
        SpringApplication.run(DemoApplication.class, args);

    }




}
