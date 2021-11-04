package com.getabstract.springDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	@GetMapping("/greeting")
	public String greeting(@RequestParam(required = false, defaultValue = "Fatmiryy")String firstName,String bestesTier, Model model) {
		String a = "joooo";
		model.addAttribute("a", a);
		model.addAttribute("firstName", firstName);
		model.addAttribute("Hund", bestesTier);
		return "greeting";
		
	}
	@GetMapping("/pets")
	public String tiere(String hunde, Model pets) {
		pets.addAttribute("Hunde sind super!!!!!", hunde);
		return "hunde";
		
	}
}
