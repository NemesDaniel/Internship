package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "racquet")
public class Racquet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column
    private String brand;

    @Column
    private String collection;

    @Column
    private Integer weight;

    @Column
    private Integer balance;

    @Column
    private Integer headSize;

    @Column
    private Integer price;

    @Column
    private Integer length;

    @Column
    private Integer gripSize;


}
