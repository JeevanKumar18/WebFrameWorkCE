package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class Book {

     private String title;
    private String author;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;
    public Book(String title, String author, Date publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Date getPublicationDate() {
        return publicationDate;
    }

    
}
