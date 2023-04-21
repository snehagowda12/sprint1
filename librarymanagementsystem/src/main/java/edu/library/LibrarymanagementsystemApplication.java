package edu.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.library.entity.Book;
import edu.library.repository.BookRepository;

@SpringBootApplication
public class LibrarymanagementsystemApplication implements CommandLineRunner {
	//Constructor Injection
		@Autowired
		private BookRepository bookrepository;
		
	public static void main(String[] args) {
		SpringApplication.run(LibrarymanagementsystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book a1 = Book.builder().name("sneha").author("BCA").category("Technology").description("COmputer ").publisher("Sneha").serialName("34").build();
		Book a2 = Book.builder().name("sneha").author("BCA").category("Technology").description("COmputer ").publisher("Sneha").serialName("34").build();
		Book a3 = Book.builder().name("sneha").author("BCA").category("Technology").description("COmputer ").publisher("Sneha").serialName("34").build();
		
		
		bookrepository.save(a1);
		bookrepository.save(a2);
		bookrepository.save(a3);
		
		System.out.println("--------------------------All saved-------------------------");

		
	}

}