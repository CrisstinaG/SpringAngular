package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;


import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;


    // Find
    @GetMapping("/api/v1/books")
    List<Book> findAll(@RequestParam(name="title", required=false) String myTitle) {
        if(myTitle == null){
            return bookRepository.findAll();
        }else {
            return bookRepository.findAll().stream().filter(c -> c.getTitle().equals(myTitle)).collect(Collectors.toList());
            // return bookRepository.findByTitle(myTitle);
        }
    }

    // Save
    @PostMapping("/api/v1/books")
    // return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Book newBook(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }

    // Find
    @GetMapping("/api/v1/books/{id}")
    Book findOne(@PathVariable Long id) {
        Book myBook = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return myBook;
    }

    // Save or update
    @PutMapping("/api/v1/books/{id}")
    Book saveOrUpdate(@RequestBody Book newBook, @PathVariable Long id) {

        return bookRepository.findById(id).map(x -> {
            x.setTitle(newBook.getTitle());
            x.setAuthor(newBook.getAuthor());
            return bookRepository.save(x);
        }).orElseGet(() -> {
            newBook.setId(id);
            return bookRepository.save(newBook);
        });
    }

    // update author only
    @PatchMapping("/api/v1/books/{id}")
    Book patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return bookRepository.findById(id).map(x -> {

            String author = update.get("author");
            String title = update.get("title");
            if (!StringUtils.isEmpty(author)) {
                x.setAuthor(author);
                return bookRepository.save(x);
            } else if(!StringUtils.isEmpty(title)){
                x.setTitle(title);
                return bookRepository.save(x);
            } 
            else {
                throw new BookUnSupportedFieldPatchException(update.keySet());
            }

        }).orElseGet(() -> {
            throw new BookNotFoundException(id);
        });

    }

    @DeleteMapping("/api/v1/books/{id}")
    void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

}
