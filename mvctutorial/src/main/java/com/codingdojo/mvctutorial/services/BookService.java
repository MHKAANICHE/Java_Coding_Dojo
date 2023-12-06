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

	// Retrieve a book by title
	public List<Book> findBook(String title) {
		return bookRepo.findByDescriptionContaining(title);
	}

	// Find All
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	// Update book !!
	public Book updateBook(Long id, String title, String descr, String lang, Integer pages) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			optionalBook.get().setTitle(title);
			optionalBook.get().setDescription(descr);
			optionalBook.get().setLanguage(lang);
			optionalBook.get().setNumberOfPages(pages);			
			return bookRepo.save(optionalBook.get());
		} else {
			return null;
		}
	}

	// Delete book
	public void delete(Book book) {
		bookRepo.delete(book);
	}

	// Delete book by ID
	public void deleteBookById(Long id) {
		bookRepo.deleteById(id);
	}

}
