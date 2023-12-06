package com.codingdojo.mvctutorial.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.mvctutorial.models.Book;
import com.codingdojo.mvctutorial.services.BookService;

@RestController
@RequestMapping("/api")
public class BookApi {
	boolean debug = true;
	// Dependency Injection 
	private final BookService bookServ;
	public BookApi(BookService bookService) {
		this.bookServ = bookService;
	}

	// API Routing : 
	// Test routing 
	@GetMapping("/test")
	/*
	 * User has to enter the proper url for test.
	 */
	public String test() {
	return "test";
	}
	// Show all books 
	/*
	 * User has to enter the proper url .
	 */
	@GetMapping("/index")
	public List<Book> showAll() {
		return bookServ.allBooks();
	}

	/*
	 * Create book : details of book are sent via JSON. 
	 * @RequestParam to retrieve data from JSON Object.
	 */
	@PostMapping("/create")
	public Book create(
				@RequestParam(value = "Title") 		String title, 
				@RequestParam(value = "Description")String descr, 
				@RequestParam(value = "Language")	String lang, 
				@RequestParam(value = "Pages")		Integer pages) {
				if(debug) {
				System.out.println("Title : " + title);
				System.out.println("Description : " + descr);
				System.out.println("Language : " + lang);
				System.out.println("Pages : " + pages);
				}
		return bookServ.createBook(new Book(title, descr, lang, pages));
	}


	// Find book by id 
	/*
	 * User has to enter the proper url with the value of "id"
	 */
	@GetMapping("/find/id/{id}")
	public Book findBookByID(@PathVariable("id") Long id) {
		return bookServ.findBook(id);
	}

	// Find book by title
	/*
	 * User has to enter the proper url with the value of "title"
	 */
	@GetMapping("/find/title/{title}")
	public List<Book> findListBookByTitle(@PathVariable ("title") String title) {
		return bookServ.findBook(title);
	}

	// Update book by id
	@PutMapping("/update/{id}")
	/*
	 * User has to enter the proper url with the value of "id"
	 * Insert changes into JSON object with postman (leave area empty is granted)
	 */
	public Book updateBook(
				@PathVariable ("id") Long id, 
				@RequestParam (value = "Title", required = false) String title, 
				@RequestParam (value = "Description", required = false ) String descr, 
				@RequestParam (value = "Language ", required = false) String lang, 
				@RequestParam (value = "Pages", required = false) Integer pages) {
		return bookServ.updateBook(id,title, descr, lang, pages);
	}

	// Delete book by ID 
	/*
	 * User has to enter the proper url with the value of "id"
	 */
	@DeleteMapping("/delete/id/{id}")
	public void deleteBook(@PathVariable long id) {
		bookServ.deleteBookById(id);
	}

	// Delete book by Title
	/*
	 * User has to enter the proper url with the value of "title"
	 */
	@DeleteMapping("/delete/title/{title}")
	public void deleteBookByTitle(String title) {
		List<Book> bookList = bookServ.findBook(title);
		if (!bookList.isEmpty()) {
			for (Book var : bookList) {
				bookServ.delete(var);
			}
		}
	}

}
