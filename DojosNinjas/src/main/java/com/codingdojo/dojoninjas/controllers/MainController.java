package com.codingdojo.dojoninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojoninjas.models.Ninja;
import com.codingdojo.dojoninjas.services.DojoService;
import com.codingdojo.dojoninjas.services.NinjaService;

@Controller
public class MainController {
	@Autowired
	private NinjaService ninjaServ;
	@Autowired
	private DojoService dojoServ;

	@GetMapping("/")
	public String dash(Model model) {
		model.addAttribute("dojosList", dojoServ.getAll());
		model.addAttribute("ninjasList", ninjaServ.getAll());
		return "dash.jsp";
	}

	@GetMapping("/dojo/{dojoId}")
	public String showDojo(@PathVariable(value="dojoId") Long dojoId ,Model model) {
		model.addAttribute("dojo", dojoServ.getById(dojoId));
		return "dojoDetails.jsp";
	}
	
	@GetMapping("/ninja/{ninjaId}")
	public String showNinja(@PathVariable(value="ninjaId") Long ninjaId ,
	@ModelAttribute("editNinja") Ninja editNinja,Model model) {
		// to retreive informations : 
		model.addAttribute("ninja", ninjaServ.getById(ninjaId));
		// to edit : 
		model.addAttribute("dojos", dojoServ.getAll());
		return "ninjaDetails.jsp";
	}
	@PostMapping("editNinja")
	public String editNinja(@ModelAttribute("editNinja")Ninja editNinja, BindingResult result, Model model) {
	if(result.hasErrors()) {
		model.addAttribute("dojos", dojoServ.getAll());
		return "ninjaDetails.jsp";
		}else {
		System.out.println("edit ninja Debug");
		System.out.println("Id : " + editNinja.getId());
		System.out.println("first name : " +editNinja.getFirstName());
		System.out.println("last name : " +editNinja.getLastName());
		System.out.println("age : " +editNinja.getAge() );
		System.out.println("dojo : " +editNinja.getDojo().getName() );
		ninjaServ.update(editNinja);
		return "redirect:/";
		}
	}

}
