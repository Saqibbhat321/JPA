package com.xworkz.persistenceexample.runner;

import com.xworkz.persistenceexample.dto.AnimeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AnimeRunner {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        AnimeEntity animeEntity= new AnimeEntity();

        try {
            entityTransaction.begin();
            animeEntity.setId(3);
            animeEntity.setName("Chota Bheam");
            animeEntity.setRatings(6);
            entityManager.persist(animeEntity);
            entityTransaction.commit();


        }catch (Exception e){
                e.printStackTrace();
        }finally {
            System.out.println("Finally block Executed");
        }
    }
}
