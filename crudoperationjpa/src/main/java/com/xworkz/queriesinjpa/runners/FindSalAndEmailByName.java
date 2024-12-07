package com.xworkz.queriesinjpa.runners;

import javax.persistence.*;
import java.util.List;

public class FindSalAndEmailByName {


    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Query query =em.createNamedQuery("salAndEmailByOfficeNO");
        query.setParameter("Name","Kamal");
        List<Object[]> objects = query.getResultList();
        for(Object[] obj :objects)
        {
            Double salary =(Double) obj[0];
            String email =(String) obj[1];
            System.out.println("Salary: "+salary+ "  Email: "+email);
        }
    }
}
