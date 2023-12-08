package com.codingdojo.burgertracker1.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	// Show All
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("burger") Burger burger) {
		List<Burger> collectionBurger = burgerServ.findAll();
		if (collectionBurger.isEmpty()) {
			collectionBurger.add(new Burger("Prototype", "Prototype", 1));
		}
		model.addAttribute("collectionBurger", collectionBurger);
		return "index.jsp";
	}

	// Create
	@PostMapping("/newBurger")
	public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {

		if (result.hasErrors()) {
			return "index.jsp"; // we should render to conserve the inputs for user.
		} else {
			burgerServ.create(burger);
			return "redirect:/";
		}
	}

	// Update
	// retrieve informations from DB
	@RequestMapping("burger/{id}/edit")
	public String edit(Model model, @PathVariable("id") Long id) {
		model.addAttribute("burgerToEdit", burgerServ.findById(id));
		return "edit.jsp";
	}

	// Validation & save data
	@PutMapping("/editBurger")
	public String update(@Valid @ModelAttribute("burgerToEdit") Burger burger, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			burgerServ.update(burger);
			return "redirect:/";
		}
	}

	// Delete
	// retrieve informations from DB
		@RequestMapping("burger/{id}/delete")
		public String delete(Model model, @PathVariable("id") Long id) {
			model.addAttribute("burgerToDelete", burgerServ.findById(id));
			return "delete.jsp";
		}

		// Validation & save data
		@DeleteMapping("/destroyBurger/{id}")
		public String destroy(@PathVariable("id") Long id) {
			burgerServ.destroy(id);
			return "redirect:/";
		}
}
