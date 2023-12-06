package com.codingdojo.mvctutorial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvctutorial.models.Book;
import com.codingdojo.mvctutorial.repositories.BookRepository;

@Service
public class BookService {

	// Dependecy injection
	private final BookRepository bookRepo;

	public BookService(BookRepository bookRepository) {
		this.bookRepo = bookRepository;
	}

	// Wrap JPA Queries :
	// Create book
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}

	// Retrieve a book by ID
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}


	// Find All
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	// Update book !!
	public Book updateBook(Long id, String title, String descr, String lang, Integer pages) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			Book bookUpdate = optionalBook.get();
			//updating book :
			// Question : are we getting book by Refrence adress or a copy of object
			// should check obj.hash() for memory adress. 
			bookUpdate.setTitle(title);
			bookUpdate.setDescription(descr);
			bookUpdate.setLanguage(lang);
			bookUpdate.setNumberOfPages(pages);	
			// saving apdate		
			return bookRepo.save(bookUpdate);
		} else {
			return null;
		}
	}

	

	// Delete book by ID
	public void deleteBookById(Long id) {
		bookRepo.deleteById(id);
	}

}
