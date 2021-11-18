package com.getabstract.springDemo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class CalculaterController
{
    @GetMapping("/calc")
    public String invNumbers(
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
