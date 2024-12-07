package com.xworkz.queriesinjpa.runners;

import javax.persistence.*;
import java.util.List;

public class FindOfficeNoAndDepartmentByName {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            Query query= em.createNamedQuery("officeAndDepart");
            query.setParameter("sirName", "Kamal");
            List<Object[]> obj = query.getResultList();
            for(Object[] result: obj)
            {
                String department= (String) result[0];
                Double officeNo=(Double) result[1];
                System.out.println("Department: " + department + ", Office Number: " + officeNo);
            }
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
