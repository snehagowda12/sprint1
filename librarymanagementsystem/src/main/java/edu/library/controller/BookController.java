package edu.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import edu.library.dto.BookDTO;
import edu.library.entity.Book;
import edu.library.service.BookService;
import jakarta.validation.Valid;

public class BookController {
	//Constructor Injection
	@Autowired
	private BookService bookService;
	
	
	//Adds a new Book
	@PostMapping("/book")
	public ResponseEntity<Book> createBook(@RequestBody @Valid BookDTO a) 
	{
		
		     Book a1 = bookService.createBook(a);
			 return new ResponseEntity<>(a1, HttpStatus.CREATED);
		
	}
	

	//Updates an Book based on their Id
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody BookDTO bookDTO)
	{
		
		bookService.updateBook(id, bookDTO);
			return ResponseEntity.ok().body(bookService.updateBook(id, bookDTO));
		
	}
	

	//Displays an book based on their name
	@GetMapping("/booksname")
	public ResponseEntity<List<Book>> getBookByName(@RequestParam(required = false) String name)
	 {
		
			List<Book> book = bookService.findByNameContaining(name);
			return ResponseEntity.ok(book);
			
	 }

	//Displays an Book based on their Author
	@GetMapping("/bookauthor")
	public ResponseEntity<List<Book>> getBookByAuthor(@RequestParam(required = false) String author)
	{
				
			List<Book> book= bookService.findByAuthorContaining(author);
			return ResponseEntity.ok(book);
					
	}
	
	//Displays an Book based on their Id
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getAllBookById(@PathVariable int id) 
	{
		
		return ResponseEntity.ok().body(bookService.getAllBookById(id));
	
	}
	

	//Deletes an Book based on their Id
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable int id)
	{
		bookService.deleteBook(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
	}
	
	//Lists all the Book
	@GetMapping("/books")
	public ResponseEntity <List<Book>>fetchAllBooks() 
	{
		
		List<Book> book = bookService.getAllBook();
		return ResponseEntity.ok(book);
	
	}
}
