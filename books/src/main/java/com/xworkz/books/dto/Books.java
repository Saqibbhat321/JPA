package com.xworkz.books.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "book_table")
public class Books
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private double price;
    private String publisher;
    private int publicationYear;
    private int numberOfPages;
    private String genre;
    private String language;
    private String summary;

    public Books(String title, String author, double price, String publisher,
                 int publicationYear, int numberOfPages, String genre, String language, String summary) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.language = language;
        this.summary = summary;
    }
}
