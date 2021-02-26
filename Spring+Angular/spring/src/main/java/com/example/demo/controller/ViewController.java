package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @Autowired
    private UserRepository repository;
    @Autowired
    private BookRepository repositoryBook;
    
    

    
    @GetMapping("/users")
    public String userListView(Model model) {
        model.addAttribute("myClass", "card-title");
        model.addAttribute("users", repository.findAll());
        return "user.html";
    }

    @GetMapping("/books")
    public String bookListView(Model model) {
         model.addAttribute("books", repositoryBook.findAll());
        return "book.html";
    }
    //-------------------------------------------------------------//
    @GetMapping("/new_user_form")
    public String addUser(Model model) {
        model.addAttribute("user",new User());
         return "newuserform.html";
    }
   
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user,BindingResult errors, Model model) {
        // logic to process input data
        model.addAttribute("myClass", "card-title");
        repository.save(user);
        return "redirect:/users";
    }

    //-------------------------------------------------------------------//

    @GetMapping("/new_book_form")
    public String addBook(Model model) {
        model.addAttribute("book",new Book());
         return "newbookform.html";
    }

   
    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute Book book,BindingResult errors, Model model) {
        // logic to process input data
        repositoryBook.save(book);
        return "redirect:/books";
    }
  //----------------------------------------------------//
  
    
    
}
