package com.codingdojo.bookstoremvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.bookstoremvc.models.Book;
import com.codingdojo.bookstoremvc.services.BookService;

@Controller
public class BookController {
// Dependency Injection 
	private final BookService bookServ;

	public BookController(BookService bookService) {
		this.bookServ = bookService;
	}

// Routing 
	// dashboard - show all
	@RequestMapping("/")
	public String dashboard(Model model) {
		List<Book> bookList = bookServ.showAll();
		if (bookList.isEmpty()) {
			bookList.add(new Book("prototype", "prototype", "prototype", "prototype", 101));
		}
		model.addAttribute("ListOfBooks", bookList);
		return "dashboard.jsp";
	}

	// Create new book
	@RequestMapping("/new")
	public String newBook() {
		return "form.jsp";
	}
	
	// On submit new book
	@RequestMapping("/OnSubmit")
	public String newBook(
				@RequestParam(value ="title",required= false) String title,
				@RequestParam(value ="author",required= false) String author,
				@RequestParam(value ="descr",required= false) String descr,
				@RequestParam(value ="lang",required= false) String lang,
				@RequestParam(value ="pages",required= false) Integer pages) {
				bookServ.create(new Book(title,author,descr,lang,pages));				
		return "redirect:/";
	}

	// show a book

	@RequestMapping("/view/{id}")
	public String OneBook(@PathVariable ("id") Long id,Model model) {
		model.addAttribute("book",bookServ.findByID(id));
		// redirected due to href ( this is not the result of form action to be rendered)
		// Issue : JSP file [/viewBook.jsp] not found - 07/12/23
		return "redirect:/viewBook.jsp";

	}

}
