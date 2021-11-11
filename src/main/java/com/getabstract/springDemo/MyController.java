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
	public String pets(@RequestParam(required = false, defaultValue = "geben Sie bitte einen Hundenamen ein!!")String hund, Model model) {
		model.addAttribute("hund", hund);
		return "pets"; }
		
		
	@GetMapping("/add")
	public String add(@RequestParam(required = false)int num1, int num2, Model model) {
		
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		int result = num1 + num2;
		model.addAttribute("result", result);
		return "add";
		
	}
	
	@GetMapping("/sub")
	public String sub(@RequestParam(required = false)int num1, int num2, Model model) {
		
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		int result = num1 - num2;
		model.addAttribute("result", result);
		return "sub";
	}
	
	
	
	
	
	
	
	@GetMapping("/calc")
	public String AddOrSub(
			@RequestParam(required = false) int num1,
			@RequestParam(required = false) int num2, 
			@RequestParam(required = false) String op,
			Model model) {
		
	
		
		int result = 9;
		String operator = "x";
		
		if(op.equals ("add")) {
			result = num1 + num2;
			operator = "+";
		} else if(op.equals  ("sub")) {
			result = num1 - num2;
			operator = "-";
		} else {
			System.out.println("Geben sie einen richtigen Wert ein");
		}		
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("op" , op);
		model.addAttribute("result", result);
		model.addAttribute("operator", operator);

		return "calc";
	}
}
