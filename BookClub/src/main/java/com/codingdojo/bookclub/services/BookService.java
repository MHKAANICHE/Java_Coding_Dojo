package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.repoitories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
// C R U D 

	public List<Book> getAll() {
		return bookRepo.findAll();
	}

	public List<Book> getAllByBorrower(User borrower) {
		return bookRepo.findByBorrower(borrower);
	}
	
	public List<Book> getAllByBorrowerNot(User borrower){
		return bookRepo.findByBorrowerIsNullOrNot(borrower);
	}

	public Book getById(Long id) {
		Optional<Book> optional = bookRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Book create(Book book) {
		return bookRepo.save(book);
	}

	public Book update(Book book) {
		return bookRepo.save(book);
	}

	public void delete(Long id) {
		Optional<Book> optional = bookRepo.findById(id);
		if (optional.isPresent()) {
			bookRepo.deleteById(id);
		}
	}

}
