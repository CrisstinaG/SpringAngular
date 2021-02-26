package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.repository.UserRepository;

import java.util.List;

import com.example.demo.error.UserNotFoundException;
import com.example.demo.model.User;


@RestController
public class UserController {
    
    @Autowired
    private UserRepository repository;

    // Find
   


    @GetMapping("/api/v1/users")
     List<User> findAll(@RequestParam(name="name", required=false) String name, Model model) {
         if(name == null){
             return repository.findAll();
         }else {
           return repository.findByFirstName(name);
         }        
     }
    

    /*Filtros:
    por nombre de usuario
    usuarios mayores de edad
    usuarios por rango de edad*/

    // Save
    @PostMapping("/api/v1/users")
    // return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    User newUser(@RequestBody User newBook) {
        return repository.save(newBook);
    }

    // Find
    @GetMapping("/api/v1/users/{id}")
    User findOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/api/v1/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
