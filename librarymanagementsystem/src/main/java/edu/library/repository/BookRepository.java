package edu.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.library.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findByAuthorContaining(String author);

	List<Book> findByNameContaining(String name);

}
