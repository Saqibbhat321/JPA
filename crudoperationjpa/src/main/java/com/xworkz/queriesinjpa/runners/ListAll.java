package com.xworkz.queriesinjpa.runners;

import com.xworkz.queriesinjpa.entities.InstituteEntity;

import javax.persistence.*;
import java.util.List;

public class ListAll {


    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Query query = em.createNamedQuery("displayAllInfo");
        List<InstituteEntity> list =query.getResultList();
        list.forEach(e-> System.out.println(e));
    }
}
