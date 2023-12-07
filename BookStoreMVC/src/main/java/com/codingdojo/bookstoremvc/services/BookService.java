package com.codingdojo.bookstoremvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.bookstoremvc.models.Book;
import com.codingdojo.bookstoremvc.repositories.BookRepository;
@Service
public class BookService {
// Dependecy Injection 
	private final BookRepository bookRepo;

	public BookService(BookRepository bookRepository) {
		this.bookRepo = bookRepository;
	}

// Buisness logic 
	// create 
		public Object create(Book book) {
			return bookRepo.save(book);
		}
	
	//find by Id
		public Book findByID(Long id) {
			Optional<Book> optionalBook = bookRepo.findById(id);
			if (optionalBook.isEmpty()) {
				return null;
			} else {
				return optionalBook.get();
			}
		}
	// update 
		public Object update(Book book) {
			return bookRepo.save(book);
		}
	// Delete
		public void delete(Long id) {
			Optional<Book> optionalBook = bookRepo.findById(id);
			if(!optionalBook.isEmpty())
			 {  bookRepo.deleteById(id); } 
		}
	//find all
		public List<Book> showAll(){
		return bookRepo.findAll();
		}

}
