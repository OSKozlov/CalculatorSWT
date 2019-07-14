package com.lux.calculator.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.widgets.Shell;

import com.lux.calculator.model.MathModel;
import com.lux.calculator.operation.MathOperation;
import com.lux.calculator.operation.MathOperationAdd;
import com.lux.calculator.operation.MathOperationDevision;
import com.lux.calculator.operation.MathOperationMultiplication;
import com.lux.calculator.operation.MathOperationSubtraction;
import com.lux.calculator.operation.MathOperationType;

public abstract class AbstractCalculator {

    protected Map<String, MathOperation> mathOperationsMap;

    public abstract void runUI(Shell shell);

    /**
     * 
     * @param firstNumber - first number which takes part in operation
     * @param secondNumber - second number which takes part in operation
     * @param mathOperator - a sign that denotes a mathematical action with numbers
     * @return result of operation
     */
    protected abstract double performOperation(double firstNumber, double secondNumber, MathOperationType sign);

    protected abstract MathModel getMathModel();

    protected abstract void creatOperationsMap();

    protected abstract void displayOperationResult(String result);

    protected abstract void displayOperationHistory(String stringExpression);

    protected abstract void clearOperationHistory();

    protected Map<String, MathOperation> creatMainOperationsMap() {
        mathOperationsMap = new HashMap<>();
        mathOperationsMap.put(MathOperationType.ADDITION.getValue(), new MathOperationAdd());
        mathOperationsMap.put(MathOperationType.SUBTRACTION.getValue(), new MathOperationSubtraction());
        mathOperationsMap.put(MathOperationType.DIVISION.getValue(), new MathOperationDevision());
        mathOperationsMap.put(MathOperationType.MULTIPLICATION.getValue(), new MathOperationMultiplication());
        return mathOperationsMap;
    }

}