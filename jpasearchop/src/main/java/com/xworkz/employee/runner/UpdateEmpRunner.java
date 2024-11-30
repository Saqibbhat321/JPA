package com.xworkz.employee.runner;

import com.xworkz.employee.dto.EmpDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateEmpRunner {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();



        try {
            et.begin();
            int value = em.createQuery("update EmpDto ed set name=:name,email=: email where ph_no=:ph_no")
                    .setParameter("name", "Hero")
                    .setParameter("email","Hero@gmail.com")
                    .setParameter("ph_no","123456789")
                    .executeUpdate();

            if(value>0)
            {
                System.out.println("name and email updated");
            }
            else {
                System.out.println("Update Failed");
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
    }
}
