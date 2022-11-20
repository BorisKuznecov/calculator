package com.epam.tat.calculator;

import com.epam.tat.calculator.impl.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTests {
    private ICalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(2);
    }
     
    @Test
    void shouldAddTwoPositiveNumbers() {
        double a = 10.1;
        double b = 6.3;
        double result = calculator.add(a, b);
        double expectedResult = 16.4;
        Assertions.assertEquals(expectedResult, result, "Wrong result of method 'add'");
    }

    @Test
    void shouldDivideTwoPositiveNumbers() {
        double a = 10.1;
        double b = 6.3;
        double result = calculator.divide(a, b);
        double expectedResult = 1.6;
        Assertions.assertEquals(expectedResult, result, "Wrong result of method 'divide'");
    }

    @Test
    void shouldMultiplyTwoPositiveNumbers() {
        double a = 10.1;
        double b = 6.3;
        double result = calculator.multiply(a, b);
        double expectedResult = 63.63;
        Assertions.assertEquals(expectedResult, result, "Wrong result of method 'multiply'");
    }

    @Test
    void shouldSubtractTwoPositiveNumbers() {
        double a = 10.1;
        double b = 6.3;
        double result = calculator.subtract(a, b);
        double expectedResult = 3.8;
        Assertions.assertEquals(expectedResult, result, "Wrong result of method 'subtract'");
    }

    @Test
    void shouldAddTwoPositiveNumbersWithTwoSymbolsPrecision() {
        double a = 10.1;
        double b = 6.354;
        double result = calculator.add(a, b);
        double expectedResult = 16.45;
        Assertions.assertEquals(expectedResult, result, "Wrong result of method 'add'");
    }
    

    @Test
    void shouldAddTwoMaxValueAndReturnPositiveInfinity () {
        double a = 1.7976931348623157*Math.pow(10,308);
        double b = 1.7976931348623157*Math.pow(10,308);
        double result = calculator.add(a, b);
        String expectedResult = "Infinity";
        Assertions.assertEquals(expectedResult, Double.toString(result), "Wrong result of method 'add'");
    }

    @Test
    void shouldAddTwoMaxValueAndReturnNegativeInfinity () {
        double a = -1.7976931348623157*Math.pow(10,308);
        double b = -1.7976931348623157*Math.pow(10,308);
        double result = calculator.add(a, b);
        String expectedResult = "-Infinity";
        Assertions.assertEquals(expectedResult, Double.toString(result), "Wrong result of method 'add'");
    }

    @Test
    void shouldSubtractPositiveAndNegativeMaxValuesAndReturnPositiveInfinity () {
        double a = 0.0000000000000001*Math.pow(10,308);
        double b = -1.7976931348623158*Math.pow(10,308);
        double result = calculator.subtract(a, b);
        String expectedResult = "Infinity";
        Assertions.assertEquals(expectedResult, Double.toString(result), "Wrong result of method 'add'");
    }

    @Test
    void shouldSubtractNegativeAndPositiveMaxValuesAndReturnNegativeInfinity () {
        double a = -0.0000000000000001*Math.pow(10,308);
        double b = 1.7976931348623157*Math.pow(10,308);
        double result = calculator.subtract(a, b);
        String expectedResult = "-Infinity";
        Assertions.assertEquals(expectedResult, Double.toString(result), "Wrong result of method 'add'");
    }

    @Test
    void shouldDivideNegativeNumberByZeroAndReturnNegativeInfinity () {
        double a = -0.0000000000000001*Math.pow(10,308);
        double b = 0;
        double result = calculator.divide(a, b);
        String expectedResult = "-Infinity";
        Assertions.assertEquals(expectedResult, Double.toString(result), "Wrong result of method 'add'");
    }

    @Test
    void shouldDividePositiveNumberByZeroAndReturnPositiveInfinity () {
        double a = 0.0000000000000001*Math.pow(10,308);
        double b = 0;
        double result = calculator.divide(a, b);
        String expectedResult = "Infinity";
        Assertions.assertEquals(expectedResult, Double.toString(result), "Wrong result of method 'add'");
    }

    @Test
    void shouldMultiplyTwoPositiveMaxValuesAndReturnPositiveInfinity () {
        double a = 1.7976931348623157*Math.pow(10,308);
        double b = 1.7976931348623157*Math.pow(10,308);
        double result = calculator.multiply(a, b);
        String expectedResult = "Infinity";
        Assertions.assertEquals(expectedResult, Double.toString(result), "Wrong result of method 'add'");
    }

    @Test
    void shouldMultiplyPositiveAndNegativeMaxValuesAndReturnNegativeInfinity () {
        double a = 1.7976931348623157*Math.pow(10,308);
        double b = -1.7976931348623157*Math.pow(10,308);
        double result = calculator.multiply(a, b);
        String expectedResult = "-Infinity";
        Assertions.assertEquals(expectedResult, Double.toString(result), "Wrong result of method 'add'");
    }


}
