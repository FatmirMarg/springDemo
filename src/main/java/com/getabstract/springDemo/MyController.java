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

    @GetMapping("/calc")
    public String AddOrSub(
            @RequestParam(required = false, defaultValue = "0") int num1,
            @RequestParam(required = false, defaultValue = "0") int num2,
            @RequestParam(required = false, defaultValue = "") String add,
            @RequestParam(required = false, defaultValue = "") String sub,
            @RequestParam(required = false, defaultValue = "") String multi,
            @RequestParam(required = false, defaultValue = "") String div,

            Model model)
    {
        String operator2 = "";
        int result = 1;

        if (add.equals("+"))
        {
            result = num1 + num2;
            operator2 = "+";
        }
        else if (sub.equals("-"))
        {
            result = num1 - num2;
        }
        else if (multi.equals("*"))
        {
            result = num1 * num2;
            operator2 = "*";
        }
        else if (div.equals("/"))
        {
            result = num1 / num2;
            operator2 = "/";
        }

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);
        model.addAttribute("operator2", operator2);

        return "calc";
    }
}
