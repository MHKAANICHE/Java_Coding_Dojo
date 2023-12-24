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

	@GetMapping("/")
	public String login(@ModelAttribute("newRegister") User newRegister, 
	@ModelAttribute("newLoggin") User newLoggin) {
		return "login.jsp";
	}

	@PostMapping("/register")
	public String userRegister(@Valid @ModelAttribute("newRegister") User newRegister,
	BindingResult result,
	Model model, HttpSession session) {
		// check registration :
		User potentialUser = userServ.userRegistration(newRegister, result);
		// check errors:
		if (result.hasErrors()) {
			// if user decide to login	
			model.addAttribute("newLoggin", new LoginUser());		
			return "login.jsp";
		} else {
			session.setAttribute("user_session", potentialUser);
			return "redirect:/classes";
		}
	}

	@PostMapping("/loggin")
	public String userLogin(@Valid @ModelAttribute("newLoggin") LoginUser newLoggin,
	 BindingResult result, 
	Model model,HttpSession session) {
		// check loggin :
		User potentialUser = userServ.userLogin(newLoggin, result);
		// check errors:
		if (result.hasErrors()) {
			// if user decide to register	
			model.addAttribute("newRegister", new User());
			return "login.jsp";
		} else {
			session.setAttribute("user_session", potentialUser);
			return "redirect:/classes";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
