package com.codingdojo.HelloHumain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class HelloHumainApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumainApplication.class, args);
	}

	@RequestMapping("")
	public String greeting(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "times", required = false) int times) {
		String message = "";
		int count = times;
		if (name == null) {
			message = "Hello Humain";
		} else {
			if (lastName == null) {
				do {
					message += "Hello " + name + " ";
					count--;
				} while (count > 0);

			} else
				do {
					message += "Hello " + name + " " + lastName + " ";
					count--;
				} while (count > 0);

		}
		return message;
	}

}
