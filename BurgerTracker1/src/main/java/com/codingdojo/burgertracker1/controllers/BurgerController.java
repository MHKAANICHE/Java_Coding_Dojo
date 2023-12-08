package com.codingdojo.burgertracker1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.burgertracker1.models.Burger;
import com.codingdojo.burgertracker1.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
// Dependecy Injection 
	private final BurgerService burgerServ;

	public BurgerController(BurgerService burgerService) {
		this.burgerServ = burgerService;
	}

// Routing
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("burger") Burger burger) {
		List<Burger> collectionBurger = burgerServ.findAll();
		if (collectionBurger.isEmpty()) {
			collectionBurger.add(new Burger("Prototype", "Prototype", 1));
		}
		model.addAttribute("collectionBurger", collectionBurger);
		return "index.jsp";
	}

	@PostMapping("/newBurger")
	public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		
		if (result.hasErrors()) {
			return "index.jsp"; // we should render to conserve the inputs for user.
		} else {
			burgerServ.create(burger);
			return "redirect:/";
		}	
	}
}
