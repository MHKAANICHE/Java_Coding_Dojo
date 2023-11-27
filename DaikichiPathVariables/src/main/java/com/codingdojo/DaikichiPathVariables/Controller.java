package com.codingdojo.DaikichiPathVariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/daikichi")
@RestController
public class Controller {
	@RequestMapping("")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/travel/{destination}")
	public String trip (@PathVariable("destination") String destination) {
		return "Congratulation! You will sonn travel to "+destination+"!";
	}
	
	@RequestMapping("/lotto/{num}")
	public String showLesson (@PathVariable("num") Integer num) {
		String message = "";
		if(num%2 == 0 ) {
			
			message = "You will take a grand journey in the near future, but be wary of tempting offers";
		}
		if(num%2 != 0) {
			message =  "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
		}
		return message ;
	
	}
}
