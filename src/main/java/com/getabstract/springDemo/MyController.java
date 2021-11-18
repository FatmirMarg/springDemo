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
            @RequestParam(required = false, defaultValue = "0") int num1,
            @RequestParam(required = false, defaultValue = "0") int num2,
            @RequestParam(required = false, defaultValue = "") String add,
            @RequestParam(required = false, defaultValue = "") String sub,
            @RequestParam(required = false, defaultValue = "") String multi,
            @RequestParam(required = false, defaultValue = "") String div,
            @RequestParam(required = false, defaultValue = "1") String one,
            @RequestParam(required = false, defaultValue = "2") String two,
            @RequestParam(required = false, defaultValue = "3") String three,
            @RequestParam(required = false, defaultValue = "4") String four,
            @RequestParam(required = false, defaultValue = "5") String five,
            @RequestParam(required = false, defaultValue = "6") String six,
            @RequestParam(required = false, defaultValue = "7") String seven,
            @RequestParam(required = false, defaultValue = "8") String eight,
            @RequestParam(required = false, defaultValue = "9") String nine,
            @RequestParam(required = false, defaultValue = "0") String zero,

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
            operator2 = "-";
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
        model.addAttribute("one", one);
        model.addAttribute("two", two);
        model.addAttribute("three", three);
        model.addAttribute("four", four);
        model.addAttribute("five", five);
        model.addAttribute("six", six);
        model.addAttribute("seven", seven);
        model.addAttribute("eight", eight);
        model.addAttribute("nine", nine);
        model.addAttribute("zero", zero);
        return "calcPro";
    }
}
