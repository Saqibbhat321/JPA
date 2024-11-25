package com.xworkz.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name="sports_table")
public class SportsDto {
    @Id
    private int id;
    private String name;
    private String no_of_players;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo_of_players() {
        return no_of_players;
    }

    public void setNo_of_players(String no_of_players) {
        this.no_of_players = no_of_players;
    }

}

