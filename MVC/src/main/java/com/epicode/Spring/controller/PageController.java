package com.epicode.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epicode.Spring.models.User;
import com.epicode.Spring.services.UserService;

@Controller
public class PageController {
	
	@Autowired UserService userService;

	@GetMapping("/")
	public String getHome() {
		return "index";
	}
	
	@GetMapping("/about")
	public String getAbout() {
		return "about";
	}
	
	@GetMapping("/address-book")
	public ModelAndView getAddressBook() {
		List<User> listaUtenti = userService.getUsersList();
		ModelAndView model = new ModelAndView("address-book");
		model.addObject("lista", listaUtenti);
		return model;
	}
	
}
