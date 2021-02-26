package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

public class BookInfo extends Book{
    List<Transaction> transactions;
    Book book;
    BookInfo(Book book, List<Transaction> transactions){
        this.book = new Book(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn());
        this.transactions = transactions;
    }
}