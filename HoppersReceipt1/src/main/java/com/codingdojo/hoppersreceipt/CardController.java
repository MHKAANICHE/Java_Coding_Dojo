package com.codingdojo.hoppersreceipt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CardController {

	@RequestMapping("/")
	public String index (Model model){
		String customerName = "Grace Hopper 2";
		String itemName = "Copper wire";
		double price = 5.25;
		String description = " Metal strips. Also an illustration of nanoseconds";
		String vendor ="Little Things Corner Store";
		
		model.addAttribute("customerName", customerName);
		model.addAttribute ("itemName", itemName);
		model.addAttribute ("price",price);
		model.addAttribute("description",description);
		model.addAttribute("vendor",vendor);
	
	return "index.jsp";
	}
}

