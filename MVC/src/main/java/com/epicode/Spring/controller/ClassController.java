package com.epicode.Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassController {

	@GetMapping("/home")
	public String getHome() {
		return "index";
	}
	
	@GetMapping("/chi-siamo")
	public String getAboutPage() {
		return "chi-siamo";
	}
}
