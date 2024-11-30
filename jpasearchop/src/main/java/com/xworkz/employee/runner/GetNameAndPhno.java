package com.xworkz.employee.runner;

import com.xworkz.employee.dto.EmpDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class GetNameAndPhno {


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com");
        EntityManager em= emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {

        et.begin();
        List<Object[]> results =em.createQuery("select e.name, e.ph_no  from EmpDto e where e.age>:eage",Object[].class)
                .setParameter("eage",25)
                .getResultList();

        et.commit();
        if(results.isEmpty())
        {
            System.out.println("no emp found with age  > 25");
        }
        else
        {
            for(Object[] result:results)
            {
                System.out.println("Name: "+result[0] +", Phone: "+result[1]);
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




