package com.xworkz.queriesinjpa.runners;

import com.xworkz.queriesinjpa.entities.InstituteEntity;

import javax.persistence.*;
import java.util.List;

public class FindByProfId {


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            Query query = em.createNamedQuery("findByProfId");
            query.setParameter("prof_id", 202328);
            List<InstituteEntity>  list= query.getResultList();
            list.forEach(e-> System.out.println(e));
//            System.out.println("   jfjsdlfj: " + );
            et.commit();

        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
