package com.codingdojo.lookify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

@GetMapping("/")
public String index() {
return "index.jsp";
}
@GetMapping("/dash")
public String dash() {
return "dash.jsp";
}
@GetMapping("/new")
public String newSong() {
return "new.jsp";
}
@GetMapping("/search")
public String search() {
return "search.jsp";
}
@GetMapping("/show")
public String show() {
return "show.jsp";
}
@GetMapping("/topTen")
public String topTen() {
return "topTen.jsp";
}
}
