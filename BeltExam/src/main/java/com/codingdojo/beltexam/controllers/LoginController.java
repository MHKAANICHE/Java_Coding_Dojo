package com.codingdojo.beltexam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.beltexam.models.LoginUser;
import com.codingdojo.beltexam.models.User;
import com.codingdojo.beltexam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	@Autowired
	private UserService userServ;

	// Home page : one single page for two form (login & registration)
	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User newUser, @ModelAttribute("newLogin") LoginUser newLogin) {
		return "login.jsp";
	}

	// Login
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {
		User user = userServ.login(newLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/dash";
	}

	// Logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	// Register 
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {
		userServ.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dash";
	}
	
	@GetMapping("/dash")
	public String logged() {
	return "index.jsp";
	}

}
