package com.getabstract.springDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController
{
    @GetMapping("/greeting")
    public String greeting(@RequestParam(required = false, defaultValue = "Fatmiryy") String firstName, Model model)
    {
        String a = "joooo";
        model.addAttribute("a", a);
        model.addAttribute("firstName", firstName);

        return "greeting";

    }

    @GetMapping("/pets")
    public String pets(
            @RequestParam(required = false, defaultValue = "geben Sie bitte einen Hundenamen ein!!") String hund,
            Model model)
    {
        model.addAttribute("hund", hund);
        return "pets";
    }

    @GetMapping("/add")
    public String add(@RequestParam(required = false) int num1, int num2, Model model)
    {

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        int result = num1 + num2;
        model.addAttribute("result", result);
        return "add";
    }

    @GetMapping("/sub")
    public String sub(@RequestParam(required = false) int num1, int num2, Model model)
    {

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        int result = num1 - num2;
        model.addAttribute("result", result);
        return "sub";
    }

    @GetMapping("/calcPro")
    public String AddOrSub(
            @RequestParam(required = false) Integer firstNumber,
            @RequestParam(required = false) Integer secondNumber,
            @RequestParam(required = false, defaultValue = "") String operator,
            @RequestParam(required = false) boolean execute, Model model)
    {
        System.out.println(operator);

        int result;
        if (secondNumber != null && execute == true)
        {

            if (operator.equals("+"))
            {
                result = firstNumber + secondNumber;
                model.addAttribute("result", result);
            }
            else if (operator.equals("-"))
            {
                result = firstNumber - secondNumber;
                model.addAttribute("result", result);
            }
            else if (operator.equals("*"))
            {
                result = firstNumber * secondNumber;
                model.addAttribute("result", result);

            }
            else if (operator.equals("/"))
            {
                result = firstNumber / secondNumber;
                model.addAttribute("result", result);

            }
        }
        model.addAttribute("firstNumber", firstNumber);
        model.addAttribute("operator", operator);
        model.addAttribute("secondNumber", secondNumber);

        return "calcPro";
    }
}
