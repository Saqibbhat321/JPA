package com.xworkz.books.runners;

import com.xworkz.books.dto.Books;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;

public class BookInsertionRunner {


    public static void main(String[] args) {

        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("com");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        List<Books> booksList = new ArrayList<>();

        booksList.add(new Books("Hzeon","saqib",230,"hmt",2024,200,"self help","english","dont stop dreaming"));
        booksList.add(new Books("sfskdlf","fhe",20,"hmt",2024,200,"self helsdfp","englisdfsdfsh","dont stop dreaming"));
        booksList.add(new Books("fhsdfsa","salhheqib",290,"df",2024,200,"ssdfsdgelf help","esdfnglish","dsdfont stop dreaming"));
        booksList.add(new Books("sdfjdsf","oif",350,"dg",2024,200,"self hesffslp","englisdfsh","donsdfsdft stop dreaming"));
        booksList.add(new Books("nsdjnjsdif","wwer",450,"df",2024,200,"selfdsfds help","english","stop dreaming"));
        booksList.add(new Books("sdnfewi","sdf",9550,"df",2024,200,"selfsdf helfsdfp","englsdish","stop dreaming"));
        booksList.add(new Books("njkbefui","sdfbsd",350,"dg",2024,200,"sefsdfdslf help","english","dont stop dreaming"));
        booksList.add(new Books("dsfsd","fhsd",150,"hmt",2024,200,"dsklfs","english"," stop dreaming"));


        try{
            et.begin();
            for(Books bookie: booksList)
            {
                Books books = new Books();

                books.setAuthor(bookie.getAuthor());
                books.setGenre(bookie.getGenre());
                books.setPrice(bookie.getPrice());
                books.setLanguage(bookie.getLanguage());
                books.setPublisher(bookie.getPublisher());
                books.setTitle(bookie.getTitle());
                books.setNumberOfPages(bookie.getNumberOfPages());
                books.setPublicationYear(bookie.getPublicationYear());
                books.setSummary(bookie.getSummary());
                em.persist(books);
            }
            et.commit();
        }catch (Exception e)
        {
            if(et.isActive())
            {
                et.rollback();
            }
            e.printStackTrace();
        }finally {
            emf.close();
            em.close();
        }
    }
}
