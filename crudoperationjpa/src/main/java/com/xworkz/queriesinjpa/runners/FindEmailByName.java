package com.xworkz.queriesinjpa.runners;

import javax.persistence.*;

public class FindEmailByName {

    public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();



        try{
            et.begin();
            Query query = em.createNamedQuery("findEmailByName");
            query.setParameter("getName", "Karthi");
            Object objj =query.getSingleResult();
            String strr = (String) objj;
            System.out.println("Email is: "+strr);
            et.commit();
        }catch (Exception e)
        {
            if(et.isActive())
            {
                et.rollback();
            }
            e.printStackTrace();
        }
        finally {
            em.close();
            emf.close();
        }
    }
}
