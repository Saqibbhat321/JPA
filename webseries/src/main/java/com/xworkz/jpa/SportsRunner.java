package com.xworkz.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SportsRunner {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            SportsDto sportsDto = new SportsDto();
            sportsDto.setId(2);
            sportsDto.setName("cahppasl");
            sportsDto.setNo_of_players("23");

//            em.persist(sportsDto);
//            em.merge(sportsDto);    // used for update on basis of Primary Key
            et.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }
}
