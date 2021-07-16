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
public class RacquetDto {

    private Integer id;

    private String brand;

    private String collection;

    private Integer weight;

    private Integer balance;

    private Integer headSize;

    private Integer price;

    private Integer length;

    private Integer gripSize;

}
