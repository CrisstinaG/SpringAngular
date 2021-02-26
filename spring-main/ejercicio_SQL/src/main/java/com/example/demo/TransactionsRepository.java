package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transaction, Long> {
    // List<Transaction> findByBookId(Long Book.id);
}
