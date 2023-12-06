package com.codingdojo.mvctutorial.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvctutorial.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	/*
	 * this will automatically allow us to create, read, update, and destroy our
	 * books; after all, it is a CRUD repository we are extending.
	 */

	/*
	 * Custom queries that follow certain format JPA creates queries behind the
	 * scene for us, depending on the method signature. The Spring Data JPA Query creation can seem magical at first.
	 */

	// this method retrieves all the books from the database
	List<Book> findAll();
	

}
