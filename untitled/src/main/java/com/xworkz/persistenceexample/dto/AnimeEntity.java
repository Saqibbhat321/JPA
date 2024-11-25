package com.xworkz.persistenceexample.dto;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="animi_table")
public class AnimeEntity {


    @Id
    private int id;
    @Column(name = "ratings")
    private double ratings;
    @Column(name = "name")
    private String name;



}
