package com.lux.calculator.ui;

import org.eclipse.swt.widgets.Shell;

import com.lux.calculator.operation.MathOperationType;

public abstract class AbstractCalculator {

    /**
     * This method display Calculator dialog
     * 
     * @param shell
     */
    public abstract void runUI(Shell shell);

    /**
     * 
     * @param firstNumber - first number which takes part in operation
     * @param secondNumber - second number which takes part in operation
     * @param mathOperator - a sign that denotes a mathematical action with numbers
     * @return result of operation
     */
    protected abstract double performOperation(double firstNumber, double secondNumber, MathOperationType sign);

    protected abstract void displayOperationResult(String result);

    protected abstract void displayExpressionInHistory(String stringExpression);

    protected abstract void clearOperationHistory();

    protected abstract void setFirstOperand(String operand);

    protected abstract void setSecondOperand(String operand);

    protected abstract void setOperation(String operation);

    protected abstract void setOnFlyMode(boolean isOnFlyMode);

    protected abstract boolean isOnFlyMode();

    protected abstract void runCalculation();

}