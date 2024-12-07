package com.xworkz.queriesinjpa.runners;

import javax.persistence.*;

public class FindSalaryById {


    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();


        Query query = em.createNamedQuery("findSalById");
        query.setParameter("id",7);
        Object obj = query.getSingleResult();
        Double sal= (Double) obj;
        System.out.println(sal);
    }
}
