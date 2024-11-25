package com.xworkz.jpa.runner;

import com.xworkz.jpa.dto.BuildingDto;

import javax.persistence.*;

public class BuildingRunner {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("xworkz");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            BuildingDto buildingDto = new BuildingDto();
            buildingDto.setId(3);
            buildingDto.setBuilding_name("Aqua");
            buildingDto.setNo_of_floor(7);
            em.merge(buildingDto);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally block executed");
        }
    }
}
