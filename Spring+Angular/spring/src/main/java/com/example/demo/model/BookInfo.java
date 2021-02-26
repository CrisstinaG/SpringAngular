package com.example.demo.model;

import java.util.List;


public class BookInfo extends Book {
    List<Transaction> transactions;
    BookInfo(Book book, List<Transaction> transactions){
        super(book.getName(), book.getAuthor(),book.getIsbn());
        this.transactions = transactions;
    }
    
}
