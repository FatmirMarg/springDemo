package com.getabstract.springDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping("/greeting")
	public String greeting(Model model) {
		String a = "joooo";
		model.addAttribute("a", a);
		return "greeting";
		
	}
	
	
}
