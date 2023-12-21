package com.codingdojo.bookclub.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private BookService bookServ;

	@Autowired
	private UserService userServ;

	@GetMapping("/dash")
	public String welcome(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user_session");
		// No user!
		if (user == null) {
			return "redirect:/logout";
		}

		model.addAttribute("user_name", user.getUserName());
		model.addAttribute("user_id", user.getId());
		model.addAttribute("notBorrowedBooks", bookServ.getAllByBorrowerNot(user));
		model.addAttribute("borrowedBooks", bookServ.getAllByBorrower(user));
		return "dash.jsp";
	}

	@GetMapping("/book/{id}/borrow")
	public String borrowBook(@PathVariable(name = "id") Long id, HttpSession session) {
		User user = (User) session.getAttribute("user_session");
		// No user!
		if (user == null) {
			return "redirect:/logout";
		}
		Book book = bookServ.getById(id);
		book.setBorrower(user);
		bookServ.update(book);
		return "redirect:/dash";
	}

	@GetMapping("/book/{id}/return")
	public String cancelBorrowingBook(@PathVariable(name = "id") Long id, HttpSession session) {
		User user = (User) session.getAttribute("user_session");
		// No user!
		if (user == null) {
			return "redirect:/logout";
		}
		Book book = bookServ.getById(id);
		book.setBorrower(null);
		bookServ.update(book);
		return "redirect:/dash";
	}

	@GetMapping("/new")
	public String newBook(@ModelAttribute("newBook") Book newBook, HttpSession session) {
		User user = (User) session.getAttribute("user_session");
		// No user!
		if (user == null) {
			return "redirect:/logout";
		}
		return "new.jsp";
	}

	@PostMapping("/saveNew")
	public String saveNewBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, HttpSession session,
			Model model) {

		User user = (User) session.getAttribute("user_session");
		// No user!
		if (user == null) {
			return "redirect:/logout";
		}

		if (result.hasErrors()) {
			return "new.jsp";
		} else {
			newBook.setOwner(user);
			bookServ.create(newBook);
			return "redirect:/dash";
		}
	}

	@GetMapping("/show/{id}")
	public String showBook(@PathVariable("id") Long id, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user_session");
		// No user!
		if (user == null) {
			return "redirect:/logout";
		}
		Book book = bookServ.getById(id);
		boolean isOwner = false;
		if (book.getOwner().getId() == user.getId()) {
			isOwner = true;
		}
		model.addAttribute("book", book);
		model.addAttribute("isOwner", isOwner);
		return "show.jsp";
	}

	@GetMapping("/book/{id}/edit/")
	public String editBook(@PathVariable("id") Long id, @ModelAttribute("editBook") Book editBook, HttpSession session,
			Model model) {
		User user = (User) session.getAttribute("user_session");
		// No user!
		if (user == null) {
			return "redirect:/logout";
		}

		model.addAttribute("book", bookServ.getById(id));
		return "edit.jsp";
	}

	@PostMapping("/saveEditBook")
	public String saveEditBook(@Valid @ModelAttribute("editBook") Book editBook, BindingResult result,
			HttpSession session, Model model) {
		User user = (User) session.getAttribute("user_session");
		// No user!
		if (user == null) {
			return "redirect:/logout";
		}

		System.out.println("we are here at -- /saveEditBook! ");
		if (result.hasErrors()) {
			System.out.println("Error test did not passed ");
			model.addAttribute("book", editBook);
			return "edit.jsp";
		}
		System.out.println("Error test passed ");
		editBook.setOwner(user);
		bookServ.update(editBook);
		return "redirect:/dash";

	}

	@RequestMapping("/book/{id}/delete/")
	public String deleteBook(@PathVariable("id") Long id, HttpSession session) {
		User user = (User) session.getAttribute("user_session");
		// No user!
		if (user == null) {
			return "redirect:/logout";
		}
		bookServ.delete(id);
		return "redirect:/dash";

	}

}
