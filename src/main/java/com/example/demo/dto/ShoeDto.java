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
public class ShoeDto {

    private Integer id;

    private String brand;

    private Integer price;

    private String gender;

    private Integer size;

    private String color;

}
