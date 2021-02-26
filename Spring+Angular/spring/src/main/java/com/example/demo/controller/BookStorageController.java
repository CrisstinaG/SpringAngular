package com.example.demo.controller;

import com.example.demo.repository.BookStorageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

import com.example.demo.error.BookNotFoundException;
import com.example.demo.model.BookStorage;

@RestController
public class BookStorageController {

    @Autowired
    private BookStorageRepository repository;

    // Find
    @GetMapping("/api/v1/bookunits")
    List<BookStorage> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/api/v1/bookunits")
    // return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    BookStorage newBookUnit(@RequestBody BookStorage newBookUnit) {
        return repository.save(newBookUnit);
    }

    // Find
    @GetMapping("/api/v1/bookunits/{id}")
    BookStorage findOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    
    @DeleteMapping("/api/v1/bookunits/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
