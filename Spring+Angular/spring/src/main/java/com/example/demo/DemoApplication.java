package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.model.BookStorage;
import com.example.demo.model.Hero;
import com.example.demo.model.Transaction;
import com.example.demo.model.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BookStorageRepository;
import com.example.demo.repository.HeroRepository;
import com.example.demo.repository.TransactionsRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
    CommandLineRunner initDatabase(HeroRepository hr, BookRepository bookRepository,UserRepository userRepository, BookStorageRepository storageRepository, TransactionsRepository repositoryTran) {
        return args -> {
            Book myBook1 = new Book("A Guide to the Bodhisattva Way of Life", "Santideva", "09876y");
            Book myBook2 = new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "4322e");
            Book myBook3 = new Book ("The Life-Changing Magic of Tidying Up", "Marie Kondo", "4567w");
            
            User user1 = new User("Juan","Pérez",24);
            User user2 = new User("Pepe","Gris",34);
            User user3 = new User("Luis","Ruiz",44);

            Hero h1 = new Hero ("Superman Spring", "Man of steel");
            Hero h2 = new Hero("Batman Spring", "Dark knight");
            Hero h3 = new Hero("Spiderman Spring", "Spiddy");

            hr.save(h1);
            hr.save(h2);
            hr.save(h3);


            bookRepository.save(myBook1);
            bookRepository.save(myBook2);
            bookRepository.save(myBook3);

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            storageRepository.save(new BookStorage(1L,myBook1));
            storageRepository.save(new BookStorage(1L,myBook1));
            storageRepository.save(new BookStorage(1L,myBook1));
            
            repositoryTran.save(new Transaction(1L,myBook1,1L,1L));
            repositoryTran.save(new Transaction(2L,myBook2,1L,1L));
            repositoryTran.save(new Transaction(3L,myBook2,1L,1L));
            

        };
    }
}
