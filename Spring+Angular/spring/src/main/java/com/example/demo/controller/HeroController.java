package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Hero;
import com.example.demo.repository.HeroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/api")
public class HeroController {


    
    @Autowired
    private HeroRepository repository;

    
    @GetMapping("heroes-list")  
    public List<Hero> allstudents() {  
         return repository.findAll();
          
    } 
    
    @DeleteMapping("delete-hero/{id}")  
    public void deleteHero(@PathVariable("id") int id,Hero hero) {  
        hero = repository.findById(id).orElse(null);
        if( hero == null){
            System.out.println("Hero con id: "+ id + "no encontrado");
        }else
            repository.deleteById(id);
    }
    
    @PostMapping("save-hero")  
    public String saveHero(@RequestBody Hero hero) {  
          repository.save(hero);
          String exito = "Guardado";
          return exito;
          
    }

}
