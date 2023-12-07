package com.codingdojo.bookstoremvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookstoremvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	// find All 
	List<Book> findAll();
}
