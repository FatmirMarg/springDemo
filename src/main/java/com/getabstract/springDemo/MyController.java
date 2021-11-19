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
            @RequestParam(required = false, defaultValue = "") String firstNumber,
            @RequestParam(required = false, defaultValue = "") String secondNumber,
            @RequestParam(required = false, defaultValue = "") String operator,
            @RequestParam(required = false, defaultValue = "0") int newInput,
            @RequestParam(required = false) boolean execute, Model model)
    {
        System.out.println(newInput);
        if (firstNumber != null && secondNumber != null && execute == true)
        {

            int firstNumberConvert = Integer.valueOf(firstNumber);
            int secondNumberConvert = Integer.valueOf(secondNumber);
            model.addAttribute("result", calculate(operator, firstNumberConvert, secondNumberConvert));

        }
        if (operator.length() <= 0)
        {
            firstNumber = firstNumber + newInput;
        }
        else
        {
            secondNumber = secondNumber + newInput;
        }

        model.addAttribute("firstNumber", firstNumber);
        model.addAttribute("operator", operator);
        model.addAttribute("secondNumber", secondNumber);

        return "calcPro";
    }

    private int calculate(String operator, int firstNumberConvert, int secondNumberConvert)
    {

        Integer result = null;
        if (operator.equals("+"))
        {
            result = firstNumberConvert + secondNumberConvert;

        }
        else if (operator.equals("-"))
        {
            result = firstNumberConvert - secondNumberConvert;

        }
        else if (operator.equals("*"))
        {
            result = firstNumberConvert * secondNumberConvert;

        }
        else if (operator.equals("/"))
        {
            result = firstNumberConvert / secondNumberConvert;

        }

        return result;
    }

}
