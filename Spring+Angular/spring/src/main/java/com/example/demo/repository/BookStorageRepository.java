package com.example.demo.repository;

import com.example.demo.model.BookStorage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStorageRepository extends JpaRepository<BookStorage,Long> {

}
