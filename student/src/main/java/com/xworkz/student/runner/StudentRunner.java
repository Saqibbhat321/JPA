package com.xworkz.student.runner;

import com.xworkz.student.dto.StudentDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentRunner {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com");
        EntityManager em =emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try{
            et.begin();
            Integer id= 1;

            // for insert we have to create another runner class and for removing another class

            StudentDto studentDto = new StudentDto();
            studentDto.setBranch("CV");
            studentDto.setName("osama");
            em.persist(studentDto);
            et.commit();

            // or removing/deleting row on bases of primary key

//            StudentDto value =em.find(StudentDto.class,id); //f
//            em.remove(value);
//            et.commit();
//            System.out.println(value);
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
