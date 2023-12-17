package com.codingdojo.savetravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.savetravel.models.Item;
import com.codingdojo.savetravel.services.ItemService;

@Controller
public class MainController {
	@Autowired
	private ItemService itemServ;

	@GetMapping("/expenses")
	public String home(@ModelAttribute("newItem") Item newItem,Model model) {
		model.addAttribute("items", itemServ.getAll());
		return "home.jsp";
	}

	@PostMapping("/saveNewItem")
	public String saveNewItem(@ModelAttribute("newItem") Item newItem) {
		itemServ.create(newItem);
		return "redirect:/expenses";
	}

	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, @ModelAttribute("editItem") Item editItem, Model model) {
		model.addAttribute("item", itemServ.getById(id));
		return "edit.jsp";
	}

	@PostMapping("/saveEditItem")
	public String saveEditItem(@ModelAttribute("editItem") Item editItem) {
		itemServ.update(editItem);
		return "redirect:/expenses";
	}

	@GetMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("item", itemServ.getById(id));
		return "show.jsp";
	}
	
	@GetMapping("/expenses/delete/{id}")
	public String show(@PathVariable("id") Long id) {
		itemServ.delete(id);
		return "redirect:/expenses";
	}

}
