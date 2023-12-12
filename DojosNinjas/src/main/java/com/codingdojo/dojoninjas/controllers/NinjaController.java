package com.codingdojo.dojoninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojoninjas.models.Ninja;
import com.codingdojo.dojoninjas.services.DojoService;
import com.codingdojo.dojoninjas.services.NinjaService;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService ninjaServ;
	@Autowired
	private DojoService dojoServ;

	@GetMapping("/ninja/new")
	public String ninja(@ModelAttribute("newNinja") Ninja newNinja, Model model) {
		model.addAttribute("dojos", dojoServ.getAll());
		return "ninja.jsp";
	}
	@PostMapping("/saveNinja")
	public String saveNinja(@ModelAttribute("newNinja") Ninja newNinja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoServ.getAll());
			return "ninja.jsp";
		} else {
			ninjaServ.create(newNinja);
			return "redirect:/";
		}
	}
}
