package com.codingdojo.songeditor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.songeditor.models.LoginUser;
import com.codingdojo.songeditor.models.Song;
import com.codingdojo.songeditor.models.User;
import com.codingdojo.songeditor.services.SongService;
import com.codingdojo.songeditor.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

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
			return "redirect:/home";
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
			return "redirect:/home";
		}
	}

//	@GetMapping("/home")
//	public String welcome(HttpSession session,Model model) {
//		User user = (User) session.getAttribute("user_session");
//		model.addAttribute("user_name", user.getUserName());
//		return "home.jsp";
//	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	//------------------------------------------

	
	
	
	

}
