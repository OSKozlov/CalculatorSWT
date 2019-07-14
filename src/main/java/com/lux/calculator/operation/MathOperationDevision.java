package com.lux.calculator.operation;

public class MathOperationDevision implements MathOperation {

    @Override
    public double calculateResult(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }

}
