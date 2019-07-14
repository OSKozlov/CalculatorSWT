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

    /**
     * This method display calculation result on UI
     * 
     * @param result
     */
    protected abstract void displayOperationResult(String result);

    /**
     * This method displays expression in history
     * 
     * @param stringExpression
     */
    protected abstract void displayExpressionInHistory(String stringExpression);

    /**
     * This method clear operations history on UI
     */
    protected abstract void clearOperationHistory();

    /**
     * This method set first operand of arithmethic operation
     * 
     * @param operand
     */
    protected abstract void setFirstOperand(String operand);

    /**
     * This method set second operand of arithmethic operation
     * 
     * @param operand
     */
    protected abstract void setSecondOperand(String operand);

    /**
     * This method set arithmethic operation
     * 
     * @param operation
     */
    protected abstract void setOperation(String operation);

    /**
     * This method set On Fly mode
     * 
     * @param isOnFlyMode
     */
    protected abstract void setOnFlyMode(boolean isOnFlyMode);

    /**
     * This method check if On Fly mode is active.
     * 
     * @return true if mode is active, otherwise return false
     */
    protected abstract boolean isOnFlyMode();

    /**
     * This method run calculation
     */
    protected abstract void runCalculation();

}