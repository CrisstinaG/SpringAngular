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
public class UserController {

    @Autowired
    private UserRepository repository;

    // Find
    @GetMapping("/api/v1/users")
    List<User> findAll(
        @RequestParam(name="ofLegalAge", required=false) String legal, 
        @RequestParam(name="minage", required=false) String minAge,
        @RequestParam(name="maxage", required=false) String maxAge) {

        return this.filteredResponse(repository.findAll(), legal, minAge, maxAge);
        
    }

    // Save
    @PostMapping("/api/v1/users")
    // return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    User newBook(@RequestBody User newBook) {
        return repository.save(newBook);
    }

    // Find
    @GetMapping("/api/v1/users/{id}")
    User findOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @DeleteMapping("/api/v1/users/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }

    List<User> filteredResponse(List<User> users, String legal, String minAge, String maxAge){
        if(legal != null) {
            if(legal.toLowerCase().equals("true")){
                return users.stream().filter(c -> c.getAge() > 17).collect(Collectors.toList());
            }else if (legal.toLowerCase().equals("false")){
                return users.stream().filter(c -> c.getAge() <= 17).collect(Collectors.toList());
            } 
        }
        if(minAge != null) {
            users = users.stream().filter(c -> c.getAge() >= Integer.parseInt(minAge)).collect(Collectors.toList());
        }
        if(maxAge != null) {
            users = users.stream().filter(c -> c.getAge() <= Integer.parseInt(maxAge)).collect(Collectors.toList());
        }
        return users;

    }

}
