package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "string")
public class StringT {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column
    private String brand;

    @Column
    private Integer price;

    @Column
    private String color;

    @Column
    private Integer gauge;

    @Column
    private String construction;

    @Column
    private String material;

}
