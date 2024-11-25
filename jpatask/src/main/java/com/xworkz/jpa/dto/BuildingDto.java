package com.xworkz.jpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name="building_table")
public class BuildingDto {

    @Id
    private int id;
    @Column(name = "building_name")
    private String building_name;
    @Column(name = "no_of_floor")
    private int no_of_floor;
}
