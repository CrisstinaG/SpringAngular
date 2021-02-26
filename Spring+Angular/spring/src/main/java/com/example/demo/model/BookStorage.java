package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookStorage {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;
    

    // avoid this "No default constructor for entity"
    public BookStorage() {
    }

    public BookStorage(Long id, Book book) {
        this.id = id;
        this.book = book;
    }

    public BookStorage(Book book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBookId() {
        return book;
    }

    public void setBookId(Book book) {
        this.book = book;
    }
    
    

    @Override
    public String toString() {
        return "BookStorage{" +
                "id=" + id +
                ", Book ID='" + book + '\'' +
                '}';
    }

}