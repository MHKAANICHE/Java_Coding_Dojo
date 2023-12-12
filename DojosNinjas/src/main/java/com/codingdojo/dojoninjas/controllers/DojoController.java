package com.codingdojo.dojoninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojoninjas.models.Dojo;
import com.codingdojo.dojoninjas.services.DojoService;

@Controller
public class DojoController {
	@Autowired
	private DojoService dojoServ;

	@GetMapping("/dojo/new")
	public String dojo(@ModelAttribute("newDojo") Dojo newDojo) {
		return "dojo.jsp";
	}

	@PostMapping("/saveDojo")
	public String saveDojo(@ModelAttribute("newDojo") Dojo newDojo, BindingResult result) {
		if (result.hasErrors()) {
			return "dojo.jsp";
		} else {
			dojoServ.create(newDojo);
			return "redirect:/";
		}
	}

}
