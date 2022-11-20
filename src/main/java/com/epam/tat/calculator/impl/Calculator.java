package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Logger;

public class Calculator implements ICalculator {

    private final int precision;
    private static final String POSITIVE_INFINITY = "Infinity";
    private static final String NEGATIVE_INFINITY = "-Infinity";
    private static final Logger logger = Logger.getGlobal();



    public Calculator(int precision) {
        this.precision = precision;
    }

    @Override
    public double add(double a, double b) {
        double result = a + b;
        if (Double.toString(result).equals(POSITIVE_INFINITY)) {
            return result;
            } else if (Double.toString(result).equals(NEGATIVE_INFINITY)) {
                return result;
                } else {
                    return roundValue(result, precision);
                    }
    }

    @Override
    public double subtract(double a, double b) {
        double result = a - b;
        if (Double.toString(result).equals(POSITIVE_INFINITY)) {
            return result;
            } else if (Double.toString(result).equals(NEGATIVE_INFINITY)) {
                return result;
                } else {
                    return roundValue(result, precision);
                    }
    }

    @Override
    public double multiply(double a, double b) {
        double result = a * b;
        if (Double.toString(result).equals(POSITIVE_INFINITY)) {
            return result;
            } else if (Double.toString(result).equals(NEGATIVE_INFINITY)) {
                return result;
                } else {
                    return roundValue(result, precision);
                    }
    }

    @Override
    public double divide(double a, double b) {
        double result = a / b;
        if (Double.toString(result).equals(POSITIVE_INFINITY)) {
            return result;
            } else if (Double.toString(result).equals(NEGATIVE_INFINITY)) {
                return result;
                } else {
                    return roundValue(result, precision);
                    }
    }

    public static void main(String[] args) {
        double variableFirst = 0.0000000000000001*Math.pow(10,308);
        double variableSecond = -1.7976931348623158*Math.pow(10,308);
        Calculator calculator = new Calculator(2);

        double resultAdd = calculator.add(variableFirst, variableSecond);
        double resultSubstract = calculator.subtract(variableFirst, variableSecond);
        double resultMultiply = calculator.multiply(variableFirst, variableSecond);
        double resultDivide = calculator.divide(variableFirst, variableSecond);

        printResultOperation(resultAdd);
        printResultOperation(resultSubstract);
        printResultOperation(resultMultiply);
        printResultOperation(resultDivide);
    }
    private static void printResultOperation(double result) {
        logger.info(Double.toString(result));
    }

    private static double roundValue(double value, int precision) {
        if (precision < 0) throw new IllegalArgumentException();
        BigDecimal bigDecimal = new BigDecimal(Double.toString(value));
        bigDecimal = bigDecimal.setScale(precision, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
