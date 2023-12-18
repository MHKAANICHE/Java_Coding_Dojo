package com.codingdojo.counter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
@Controller
public class PageController {
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		// Session Control :
		checkSession(session,1);
		// Model routing control :
		model.addAttribute("page","your_server");	
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		checkSession(session,1);
		// Model routing control :
		model.addAttribute("page","counter");
		return "index.jsp";
	}
	
	@RequestMapping("/Extracounter")
	public String extraCounter(HttpSession session, Model model) {
		checkSession(session,2);
		// Model routing control :
		model.addAttribute("page","counter");
		return "index.jsp";
	}
	
	private void checkSession(HttpSession session, Integer var) {
		/*
		 * getAttribute(String name) Returns the object bound with the specified name in
		 * this session, or null if no object is bound under the name.
		 */
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			int count = (int) session.getAttribute("count");
			count += var;
			session.setAttribute("count", count);
		}
	}
}
