package com.getabstract.springDemo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyControllerTest
{

    MyController controller = new MyController();

    @Test
    void adidtionTest()
    {
        Assertions.assertEquals(0, controller.addition(0, 0));
        Assertions.assertEquals(10, controller.addition(10, 0));
        Assertions.assertEquals(12, controller.addition(10, 2));
    }

    @Test
    void sub()
    {
        Assertions.assertEquals(0, controller.sub(0, 0));
        Assertions.assertEquals(10, controller.sub(20, 10));
        Assertions.assertEquals(-1, controller.sub(1, 2));
    }

    @Test
    void div()
    {
        Assertions.assertEquals(1, controller.div(1, 1));
        Assertions.assertEquals(2, controller.div(20, 10));
        Assertions.assertEquals(0, controller.div(1, 2));
    }

    @Test
    void multi()
    {
        Assertions.assertEquals(1, controller.multi(1, 1));
        Assertions.assertEquals(200, controller.multi(20, 10));
        Assertions.assertEquals(2, controller.multi(1, 2));
    }

    @Test
    void calculate()
    {
        Assertions.assertEquals(2, MyController.calculate("+", 1, 1));
        Assertions.assertEquals(0, MyController.calculate("-", 1, 1));
        Assertions.assertEquals(1, MyController.calculate("/", 1, 1));
        Assertions.assertEquals(1, MyController.calculate("*", 1, 1));

        // assertThat(
        // MyController.calcModel(MyController.CalcInput.builder()
        // .firstNumber(1)
        // .operator("+")
        // .secondNumber(2)
        // .build()).getResult(),
        // is(equalTo(3)));

        assertThat(
                MyController.calcModel(MyController.CalcInput.builder()
                        .firstNumber(1)
                        .operator("+")
                        .secondNumber(2)
                        .button("=")
                        .build()),
                is(equalTo(MyController.CalcOutput.builder()
                        .firstNumber(0)
                        .operator("")
                        .secondNumber(0)
                        .result("3")
                        .build())));

        assertThat(
                MyController.calcModel(MyController.CalcInput.builder()
                        .firstNumber(1)
                        .operator("")
                        .secondNumber(0)
                        .button("1")
                        .build()),
                is(equalTo(MyController.CalcOutput.builder()
                        .firstNumber(11)
                        .operator("")
                        .secondNumber(0)
                        .result("")
                        .build())));

        assertThat(
                MyController.calcModel(MyController.CalcInput.builder()
                        .firstNumber(11)
                        .operator("+")
                        .secondNumber(33)
                        .button("1")
                        .build()),
                is(equalTo(MyController.CalcOutput.builder()
                        .firstNumber(11)
                        .operator("+")
                        .secondNumber(331)
                        .result("")
                        .build())));
    }

}
