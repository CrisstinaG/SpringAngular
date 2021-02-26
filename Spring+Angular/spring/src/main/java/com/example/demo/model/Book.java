package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String author;
    private String isbn;
    
    @OneToMany(
        mappedBy = "book",    
        cascade = CascadeType.ALL, 
        orphanRemoval = true)
  
    private List<BookStorage> units;

    @OneToMany(
        mappedBy = "book",    
        cascade = CascadeType.ALL, 
        orphanRemoval = true)
  
    private List<Transaction> transaction;

    // avoid this "No default constructor for entity"
    public Book() {
    }

    public Book(Long id, String name, String author, String isbn) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }

    public Book(String name, String author, String isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isbn =" + isbn +
                ", units=" + units.toString() +
                '}';
    }

}
