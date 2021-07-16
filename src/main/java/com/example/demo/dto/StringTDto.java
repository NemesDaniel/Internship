package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class StringTDto {

    private Integer id;

    private String brand;

    private Integer price;

    private String color;

    private Integer gauge;

    private String construction;

    private String material;
}
