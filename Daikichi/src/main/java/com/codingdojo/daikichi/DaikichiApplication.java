package com.codingdojo.daikichi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RestController
@RequestMapping("/daikichi")
public class DaikichiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaikichiApplication.class, args);
	}

	@RequestMapping("")
	public String index() {
		return "Welcome!";
	}

	@RequestMapping("/today")
	public String todayLuck() {
		return "Today you will find luck in all your endeavors!";
	}

	@RequestMapping("/tomorrow")
	public String tomorrowLuck() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}

}
