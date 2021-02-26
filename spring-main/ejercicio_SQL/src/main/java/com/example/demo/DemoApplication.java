package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import java.math.BigDecimal;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// @Bean
    // CommandLineRunner initDatabase(BookRepository bookRepository, UserRepository userRepository, BookStorageRepository bookStorageRepository, TransactionsRepository transactionsRepository) {
    //     return args -> {
    //         bookRepository.save(new Book("1984", "Orwell", "978-3-16-148410-0"));
    //         bookRepository.save(new Book("The Life-Changing Magic of Tidying Up", "Marie Kondo", "978-3-16-148410-1"));
    //         bookRepository.save(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "978-3-16-148410-2"));
    //         userRepository.save(new User("Uno", "Cualquiera",25));
    //         userRepository.save(new User("Otro", "Más",17));
    //         bookStorageRepository.save(new BookStorage(new Book(1L,"1984", "Orwell", "978-3-16-148410-0")));
    //         bookStorageRepository.save(new BookStorage(new Book(1L,"1984", "Orwell", "978-3-16-148410-0")));
    //         bookStorageRepository.save(new BookStorage(new Book(1L,"1984", "Orwell", "978-3-16-148410-0")));
    //         transactionsRepository.save(new Transaction(new Book(1L,"1984", "Orwell", "978-3-16-148410-0"),4L,7L));

    //     };
    // }

}
