package com.codingdojo.lookify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class MainController {
	@Autowired
	private SongService songServ;

	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}

	@GetMapping("/dash")
	public String dash(Model model) {
		model.addAttribute("songs", songServ.getAll());
		return "dash.jsp";
	}

	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("newSong") Song newSong) {
		return "new.jsp";
	}

	@PostMapping("/saveNew")
	public String saveSong(@ModelAttribute("newSong") Song newSong) {
		songServ.create(newSong);
		return "redirect:/dash";
	}

	@PostMapping("/search")
	public String search(@RequestParam("artistSearch") String artistSearch) {
		return "redirect:/search/"+artistSearch;
	}
	
	@GetMapping("/search/{artist}")
	public String searchPage(@PathVariable("artist") String artist, 
	Model model) {
		model.addAttribute("artist",artist);
		model.addAttribute("songs", songServ.getAllByArtist(artist));
		return "search.jsp";
	}

	@GetMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", songServ.getOneById(id));
		return "show.jsp";
	}

	@GetMapping("/songs/top-ten")
	public String topTen(Model model) {
	model.addAttribute("songsRated", songServ.getAllSortedByRating());
		return "topTen.jsp";
	}

	@GetMapping("/songs/{id}/delete")
	public String delet(@PathVariable(name="id")Long id) {
	songServ.deleteById(id);
	return "redirect:/dash";
	}
}
