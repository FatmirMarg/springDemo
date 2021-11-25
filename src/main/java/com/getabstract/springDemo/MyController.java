package com.getabstract.springDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Builder;
import lombok.Value;

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
    public String calc(
            @RequestParam(required = false, defaultValue = "0") String firstNumber,
            @RequestParam(required = false, defaultValue = "0") String secondNumber,
            @RequestParam(required = false, defaultValue = "?") String operator,
            @RequestParam(required = false, defaultValue = "") String button,
            Model model)
    {
        CalcOutput output = calcModel(
                CalcInput.builder()
                        .firstNumber(Integer.valueOf(firstNumber))
                        .secondNumber(Integer.valueOf(secondNumber))
                        .operator(operator)
                        .button(button)
                        .build());

        model.addAttribute("firstNumber", output.firstNumber);
        model.addAttribute("operator", output.operator);
        model.addAttribute("secondNumber", output.secondNumber);
        model.addAttribute("result", output.result);

        return "calcPro";
    }

    @Value
    @Builder
    public static class CalcInput
    {
        int firstNumber;
        int secondNumber;
        String operator;
        String button;
    }

    @Value
    @Builder
    public static class CalcOutput
    {
        int firstNumber;
        int secondNumber;
        String operator;
        String result;
    }

    protected static CalcOutput calcModel(CalcInput input)
    {
        return MyController.CalcOutput.builder()
                .firstNumber(input.firstNumber)
                .operator(input.operator)
                .secondNumber(input.secondNumber)
                .result("" + calculate(input.operator, input.firstNumber, input.secondNumber))
                .build();
    }

    protected static int calculate(String operator, int firstNumberConvert, int secondNumberConvert)
    {

        if (operator.equals("+"))
        {
            return firstNumberConvert + secondNumberConvert;

        }
        else if (operator.equals("-"))
        {
            return firstNumberConvert - secondNumberConvert;

        }
        else if (operator.equals("*"))
        {
            return firstNumberConvert * secondNumberConvert;

        }
        else if (operator.equals("/"))
        {
            return firstNumberConvert / secondNumberConvert;

        }
        else if (operator.equals("?"))
        {
            return 0;

        }
        throw new IllegalArgumentException();
    }

    protected int addition(int firstN, int secondN)
    {
        return firstN + secondN;

    }

    protected int sub(int firstN, int secondN)
    {
        return firstN - secondN;

    }

    protected int div(int firstN, int secondN)
    {
        return firstN / secondN;

    }

    protected int multi(int firstN, int secondN)
    {
        return firstN * secondN;

    }

}
