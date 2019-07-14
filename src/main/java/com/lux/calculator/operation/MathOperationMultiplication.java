package com.lux.calculator.operation;

public class MathOperationMultiplication implements MathOperation {

    @Override
    public double calculateResult(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

}
