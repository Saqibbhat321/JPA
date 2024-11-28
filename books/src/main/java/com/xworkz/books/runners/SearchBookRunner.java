package com.xworkz.books.runners;

import com.xworkz.books.dto.Books;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SearchBookRunner {


    public static void main(String[] args) {

        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("com");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            Integer id = 1;
            Books books = em.find(Books.class,id);
            if(books!=null)
            {
            System.out.println("book name "+books.getTitle());

            }
            et.commit();


        }catch (Exception e)
        {
            e.printStackTrace();

        }
        finally {
            System.out.println("finally block");
        }
    }
}
