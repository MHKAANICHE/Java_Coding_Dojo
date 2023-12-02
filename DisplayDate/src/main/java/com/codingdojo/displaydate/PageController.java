package com.codingdojo.displaydate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {
	Date date = new Date();
	Calendar calendar = Calendar.getInstance();
		
	@RequestMapping("/")
	public String index(Model model) {
	model.addAttribute("view","index");
	return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model){

	String pattern = "EEEEE, MMM dd, yyyy";
SimpleDateFormat simpleDateFormat =
        new SimpleDateFormat(pattern);
String date = simpleDateFormat.format(new Date());
 	
	model.addAttribute("view","date");
	model.addAttribute("info", date);
	
	return "index.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model){
	
	String pattern = "HH:mm aa";
SimpleDateFormat simpleDateFormat =
        new SimpleDateFormat(pattern);
String date = simpleDateFormat.format(new Date());

	model.addAttribute("view","time");
	model.addAttribute("info", date);

	return "index.jsp";
	}
}

/*ressource : https://jenkov.com/tutorials/java-internationalization/simpledateformat.html*/
