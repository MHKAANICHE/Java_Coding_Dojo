package com.codingdojo.productsandcategories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

@GetMapping("/")
private String home() {
return "home.jsp";
}
@GetMapping("/products/new")
private String newProduct() {
return "newProduct.jsp";
}
@GetMapping("/categories/new")
private String newCategory() {
return "newCategory.jsp";
}
@GetMapping("/products/1")
private String productPage() {
return "productPage.jsp";
}
@GetMapping("/categories/1")
private String categoryPage() {
return "categoryPage.jsp";
}


}
