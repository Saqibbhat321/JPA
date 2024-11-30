package com.xworkz.employee.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class SearchByInitials {


    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com");
        EntityManager em =emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            List<String> result = em.createQuery("select e.email from EmpDto e where e.name like :sName or e.name like :hName", String.class)
                    .setParameter("sName", "S%")
                    .setParameter("hName", "h%")
                    .getResultList();
            et.commit();
            if (result.isEmpty()) {
                System.out.println("no name found with s of n initials");
            } else
            {
                for(String res: result)
                {
                    System.out.println("Email: "+res);
                }
            }
        }catch (Exception e)
        {
            if(et.isActive())
            {
                et.rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }
    }
}
