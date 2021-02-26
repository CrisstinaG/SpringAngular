package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookStorage{" +
                "id=" + id +
                ", Book ='" + book.toString() + '\'' +
                '}';
    }

}
