package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;
   

    @Column(name ="user_id")
    private Long userId;
    
    @Column(name ="bookStorage_id")
    private Long bookStorageId;

    // avoid this "No default constructor for entity"
    public Transaction() {
    }

    public Transaction(Long id, Book book, Long userId, Long bookStorageId) {
        this.id = id;
        this.book = book;
        this.userId = userId;
        this.bookStorageId = bookStorageId;
    }

    public Transaction(Book book, Long userId, Long bookStorageId) {
        this.book = book;
        this.userId = userId;
        this.bookStorageId = bookStorageId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Book getBookId() {
        return book;
    }

    public void setBookId(Book book) {
        this.book = book;
    }

    public Long getBookStorageId() {
        return bookStorageId;
    }

    public void setBookStorageId(Long bookStorageId) {
        this.bookStorageId = bookStorageId;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", Book ID='" + book.toString() + '\'' +
                ", USer ID='" + userId + '\'' +
                ", Book Storage ID ID='" + bookStorageId + '\'' +
                '}';
    }

}
