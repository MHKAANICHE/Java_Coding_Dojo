package com.codingdojo.omikujiform;

import com.codingdojo.omikujiform.Card;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public String show(
	@RequestParam(value = "luckyNumber", required=false) Integer luckyNumber ,
	@RequestParam(value = "cityName", required=false) String cityName, 
	@RequestParam(value = "userName", required=false) String userName,
	@RequestParam(value = "userProfession", required=false) String userProfession,
	@RequestParam(value = "livingThing", required=false) String livingThing, 	
	@RequestParam(value = "message", required=false) String message,
	HttpSession session) {

		session.setAttribute("card", new Card(luckyNumber, cityName, userName, userProfession, livingThing, message));

		return "show.jsp";

	}

}
