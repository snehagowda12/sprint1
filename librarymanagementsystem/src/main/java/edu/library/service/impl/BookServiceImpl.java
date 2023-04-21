package edu.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.library.dto.BookDTO;
import edu.library.entity.Book;
import edu.library.exception.UserNotFoundException;
import edu.library.repository.BookRepository;
import edu.library.service.BookService;

public class BookServiceImpl implements BookService {
	@Autowired // Constructor Injection
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book createBook(BookDTO bookDTO) {
		// TODO Auto-generated method stub
		Book book = Book.builder().name(bookDTO.getName()).author(bookDTO.getAuthor()).category(bookDTO.getCategory()).description(bookDTO.getDescription()).serialName(bookDTO.getSerialName()).build();
		return  bookRepository.save(book);
	}

	@Override
	public Book updateBook(int id, BookDTO bookDTO) {
		// TODO Auto-generated method stub
		Optional<Book> adata = bookRepository.findById(id);
		if (adata.isPresent()) {
		Book _book = bookRepository.findById(id).get();
		_book.setName(bookDTO.getName());
		_book.setAuthor(bookDTO.getAuthor());
		_book.setCategory(bookDTO.getCategory());
		_book.setDescription(bookDTO.getDescription());
		_book.setSerialName(bookDTO.getSerialName());
		return bookRepository.save(_book);
	} 
	else 
		
		throw new UserNotFoundException("No user bearing id " + id + " can be found");
	
	}
	@Override
	public Book getAllBookById(int id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("No user bearing id " + id + " can be found"));
	}

	@Override
	public List<Book> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		if (bookRepository.findByNameContaining(name).isEmpty())

			throw new UserNotFoundException("No book bearing name " + name + " can be found");

		else

			return bookRepository.findByNameContaining(name);
	}

	@Override
	public List<Book> findByAuthorContaining(String author) {
		// TODO Auto-generated method stub
		if (bookRepository.findByAuthorContaining(author).isEmpty())

			throw new UserNotFoundException("No book with author " + author + " can be found");

		else

			return bookRepository.findByAuthorContaining(author);
	}

	@Override
	public String deleteBook(int id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
		return "book bearing Id " + id + "has been deleted sucessfully!";
	}

}

