package com.codingdojo.songeditor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.songeditor.models.Song;
import com.codingdojo.songeditor.models.User;
import com.codingdojo.songeditor.services.SongService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	private SongService songServ;

	@GetMapping("/home")
	public String welcome(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user_session");
		model.addAttribute("user_name", user.getUserName());
		model.addAttribute("songs", songServ.getAll());
		return "home.jsp";
	}

	@GetMapping("/new")
	public String newSong(@ModelAttribute("newSong") Song newSong) {
		return "new.jsp";
	}
	
	@PostMapping("/newSong")
	public String saveSong(@Valid @ModelAttribute("newSong") Song newSong, 
	BindingResult result, HttpSession session,Model model) {
		if (result.hasErrors()) {
			// render data for user
			return "new.jsp";
		} else {
			User user = (User) session.getAttribute("user_session");
			newSong.setAuthor(user);
			songServ.create(newSong);
			return "redirect:/home";
		}
	}

	@GetMapping("/song/{id}")
	public String showSong(@PathVariable("id") Long id, Model model ) {
		Song song = songServ.getById(id);
		model.addAttribute("song", song);
		model.addAttribute("author_name", song.getAuthor().getUserName());	
		model.addAttribute("contributors", song.getSongContributions());			
				return "show.jsp";
	}


	@GetMapping("/song/{id}/edit")
	public String editSong(@PathVariable("id") Long id, 
	@ModelAttribute("lyricsEdit") String lyricsEdit,
	Model model, 
	HttpSession session) {
		// Song attributes : 
		Song song = songServ.getById(id);
		model.addAttribute("song", song);
		
		// check Song author (ownership):
		User user = (User) session.getAttribute("user_session");
		boolean author = false;
		if(song.getAuthor().getId()==user.getId()) {author = true;}
		model.addAttribute("author", author);
		if(author) {}
		// save service on song edit 
		if(!author) {}
		// save service on contribution 
		return "edit.jsp";
	}
	
	@PostMapping("/songEdit")
	public String saveEditSong(@ModelAttribute("lyricsEdit") String lyricsEdit,
	BindingResult result, Model model) {
		return null;
	}

	
}
