package com.codingdojo.songeditor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.songeditor.models.Song;
import com.codingdojo.songeditor.models.SongContribution;
import com.codingdojo.songeditor.models.User;
import com.codingdojo.songeditor.services.SongContributionService;
import com.codingdojo.songeditor.services.SongService;
import com.codingdojo.songeditor.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	private SongService songServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private SongContributionService contribServ;
	
	@GetMapping("/home")
	public String welcome(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user_session");
	    // No user!
	    if (user == null) {
	        return "redirect:/logout";
	    }
		
		model.addAttribute("user_name", user.getUserName());
		model.addAttribute("songs", songServ.getAll());
		return "home.jsp";
	}

	@GetMapping("/new")
	public String newSong(@ModelAttribute("newSong") Song newSong, HttpSession session) {
		User user = (User) session.getAttribute("user_session");
	    
	    // No user!
	    if (user == null) {
	        return "redirect:/logout";
	    }
	    
		return "new.jsp";
	}

	@PostMapping("/newSong")
	public String saveSong(@Valid @ModelAttribute("newSong") Song newSong, BindingResult result, HttpSession session,
			Model model) {
		User user = (User) session.getAttribute("user_session");
	    
	    // No user!
	    if (user == null) {
	        return "redirect:/logout";
	    }

		if (result.hasErrors()) {
			// render data for user
			return "new.jsp";
		} else {
			
			newSong.setAuthor(user);
			songServ.create(newSong);
			return "redirect:/home";
		}
	}

	@GetMapping("/song/{id}")
	public String showSong(@PathVariable("id") Long id, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user_session");
	    
	    // No user!
	    if (user == null) {
	        return "redirect:/logout";
	    }
	    model.addAttribute("user_name", user.getUserName());

		Song song = songServ.getById(id);
		model.addAttribute("song", song);
		
		model.addAttribute("author_name", song.getAuthor().getUserName());
		model.addAttribute("contributors", song.getSongContributions());
		return "show.jsp";
	}

	@GetMapping("/song/{id}/edit")
	public String editSong(@PathVariable("id") Long id,
	Model model,HttpSession session) {
		// check Session : 
		User user = (User) session.getAttribute("user_session");
	    // No user!
	    if (user == null) {
	        return "redirect:/logout";
	    }
	    model.addAttribute("user_name", user.getUserName());

		// Song attributes :
		Song song = songServ.getById(id);
		model.addAttribute("song", song);
		
		
		// check Song author (ownership):
		boolean isAuthor = false;
		if (song.getAuthor().getId() == user.getId()) {
			isAuthor = true;
		}
		model.addAttribute("isAuthor", isAuthor);
		
		return "edit.jsp";
	}

	@PostMapping("/songEdit")
	public String saveEditSong(
	@RequestParam(name= "song_id") Long song_id, 
	@RequestParam(name= "lyricsEdit", required = false) String lyricsEdit,  
	Model model,HttpSession session) {
		// check Session : 
		User user = (User) session.getAttribute("user_session");	    
	    // No user!
	    if (user == null) {
	        return "redirect:/logout";
	    }
	    model.addAttribute("user_name", user.getUserName());
		
	    Song song = songServ.getById(song_id);
	    
		
		// check Song author (ownership):
		boolean isAuthor = false;
		if (song.getAuthor().getId() == user.getId()) {
			isAuthor = true;
		}			
		model.addAttribute("isAuthor", isAuthor);
		
		if (isAuthor) {
			song.setLyrics(lyricsEdit);
			songServ.update(song);
			return "redirect:/home";
		}
		// save service on song edit
		if (!isAuthor) {
			SongContribution contrib = new SongContribution(user,song,lyricsEdit);
			contribServ.create(contrib);
			song.getSongContributions().add(contrib);
			
			// append contribution to lyrics and update 
			String newlyrics = song.getLyrics();
			song.setLyrics(newlyrics.concat(lyricsEdit));
			songServ.update(song);
			return "redirect:/home";
		}
		// save service on contribution
		return null;
	}
	
	@PostMapping("/delete/song/{id}")
	public String deleteSong(@PathVariable("id") Long id, HttpSession session) {
		// check Session : 
		User user = (User) session.getAttribute("user_session");	    
	    // No user!
	    if (user == null) {
	        return "redirect:/logout";
	    }
	    
	    // delete contribution (null)
	    // delete song 
	    	songServ.deleteById(id);
	    return "redirect:/home";
	    
	}

	

}
