package com.codingdojo.ninjagoldgame;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	ArrayList<String> messages = new ArrayList<String>();

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/play")
	public String play(@RequestParam(value = "playerChoice") String playerChoice, HttpSession session,RedirectAttributes redirectAttributes) {
		System.out.println("playerChoice :"+playerChoice);
		Integer hitScore = 0;
		boolean win = false ;
		switch (playerChoice) {
		case "Farm":
			win = true;
			hitScore += random(10,20);
			messages.add(0,"At the Farm : Ninja won "+hitScore+" pieces of gold !.");
			break;
		case "Cave":
			win = true;
			hitScore += random(5,10);
			messages.add(0,"At the Cave : Ninja won "+hitScore+" pieces of gold !.");
			break;	
		case "House":
			win = true;
			hitScore += random(2,5);
			messages.add(0,"At the House : Ninja won "+hitScore+" pieces of gold !.");
			break;
		case "Casino":
			win = true;
			hitScore += random(0,50);
			if((hitScore.intValue()%2==0)) {
				messages.add(0,"At the Casino : Ninja won "+hitScore+" pieces of gold !.");}
			else {
				win = false;
				hitScore  *= -1 ;
				messages.add(0,"At the Casino : Ninja lost "+hitScore+" pieces of gold !.");}
			
			break;				
		default:
			System.out.println("Error : incomprehensive choice !");
		}

		if (Objects.isNull(session.getAttribute("score"))) {
			session.setAttribute("score", hitScore);			
		} else {
			Integer playerScore = (Integer) session.getAttribute("score");
			session.setAttribute("score", playerScore + hitScore);
		}
		// Update message 
		session.setAttribute("messages", messages);
	
		return "redirect:/";
	}

	private Integer random(Integer min, Integer max) {
		//System.out.println(Math.random());
		return (int) (Math.random()*(max-min)+min);
	}

}
