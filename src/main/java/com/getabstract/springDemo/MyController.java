package com.getabstract.springDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	@GetMapping("/greeting")
	public String greeting(@RequestParam(required = false, defaultValue = "Fatmiryy")String firstName, Model model) {
		String a = "joooo";
		model.addAttribute("a", a);
		model.addAttribute("firstName", firstName);

		return "greeting";
		
	}
	
	@GetMapping("/pets")
	public String pets(String hund, Model model) {
		
		model.addAttribute("hund", hund);
		return "pets";
		
	}
	
}
