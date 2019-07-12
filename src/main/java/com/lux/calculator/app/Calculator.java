package com.lux.calculator.app;

import org.eclipse.swt.widgets.Shell;

import com.lux.calculator.logic.MathOperation;
import com.lux.calculator.ui.CalculatorComposite;

public class Calculator extends AbstractCalculator {

    public Calculator() {
        creatOperationsMap();
    }

    @Override
    public double doCalculation(double firstNumber, double secondNumber, String mathOperator) {
        MathOperation mathOperation = null;

        if (mathOperationsMap.containsKey(mathOperator)) {
            mathOperation = mathOperationsMap.get(mathOperator);
        } else {
            System.out.println("Invalid sign");
        }

        return mathOperation.calculateResult(firstNumber, secondNumber);
    }

    @Override
    public void creatOperationsMap() {
        mathOperationsMap = creatMainOperationsMap();
    }

    @Override
    public void runUI(Shell shell) {
        CalculatorComposite calculatorComposite = new CalculatorComposite(shell);
    }
}
