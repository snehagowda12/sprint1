package edu.library.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.library.dto.BookDTO;
import edu.library.entity.Book;

@Component
public interface BookService {
	//To get record of all the Book
			List<Book> getAllBook();
			
			//To add a new Book
			Book createBook(BookDTO bookDTO);
			
			//To update an Book using Id
			Book updateBook(int id,BookDTO bookDTO);
			
			//To display an Book using Id
			Book getAllBookById(int id);
			
			//To display an Book using its name
			List<Book> findByNameContaining(String name);
			
			//To display an Book using its name
			List<Book> findByAuthorContaining(String author);
			
			//To delete an Book by its Id
			String deleteBook(int id);
}
