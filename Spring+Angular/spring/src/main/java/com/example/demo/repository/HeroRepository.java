package com.example.demo.repository;

import com.example.demo.model.Hero;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Integer> {
   
}
