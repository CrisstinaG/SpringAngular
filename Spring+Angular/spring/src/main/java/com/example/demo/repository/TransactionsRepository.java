package com.example.demo.repository;



import com.example.demo.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transaction, Long> {
   
}
