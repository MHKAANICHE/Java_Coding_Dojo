package com.codingdojo.fruitloops;
import com.codingdojo.fruitloops.Item;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

	@RequestMapping("/")
	public String index(Model model) {
	ArrayList<Item> itemList = new ArrayList<Item> ();
	itemList.add(new Item("Banan",1.25));
	itemList.add(new Item("Kiwi",3.21));
	itemList.add(new Item("Manga",5.01));
	
	model.addAttribute("itemList",itemList);
	return "index.jsp" ;
	}

}
