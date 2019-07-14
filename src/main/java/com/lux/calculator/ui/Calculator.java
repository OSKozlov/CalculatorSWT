package com.lux.calculator.ui;

import org.eclipse.swt.widgets.Shell;

import com.lux.calculator.event.MathOperationEvent;
import com.lux.calculator.listener.MathModelChangeListener;
import com.lux.calculator.model.MathModel;
import com.lux.calculator.operation.MathOperation;
import com.lux.calculator.operation.MathOperationType;

public class Calculator extends AbstractCalculator implements MathModelChangeListener {

    private MathModel mathModel;
    private CalculatorComposite calculatorComposite;

    private static Calculator instance;

    private Calculator() {
        creatOperationsMap();

        init();
        initListeners();
    }

    private void init() {
        mathModel = MathModel.getInstance();
    }

    private void initListeners() {
        mathModel.addMathModelChangeListener(this);
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    @Override
    public double performOperation(double firstNumber, double secondNumber, MathOperationType mathOperator) {
        MathOperation mathOperation = null;

        if (mathOperationsMap.containsKey(mathOperator.getValue())) {
            mathOperation = mathOperationsMap.get(mathOperator.getValue());
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
        calculatorComposite = new CalculatorComposite(shell);
    }

    @Override
    public void update(MathOperationEvent event) {
        System.err.println("MATH EVENT !!!!!!!!!");
        double result = performOperation(event.getFirstOperand(), event.getSecondOperand(), event.getType());
        System.err.println("result: " + result);
        displayOperationResult(String.valueOf(result));

        StringBuilder sb = new StringBuilder();
        sb.append(event.getFirstOperand());
        sb.append(" ");
        sb.append(event.getType()
                       .getOperationSign());
        sb.append(" ");
        sb.append(event.getSecondOperand());
        sb.append("=");
        sb.append(result);

        displayOperationHistory(sb.toString());
    }

    @Override
    protected void displayOperationResult(String result) {
        calculatorComposite.getMathOperationPanel()
                           .updateResultField(result);
    }

    @Override
    protected void displayOperationHistory(String stringExpression) {
        calculatorComposite.getHistoryPanel()
                           .addStatementToHistory(stringExpression);
    }

    @Override
    protected void clearOperationHistory() {
        calculatorComposite.getHistoryPanel()
                           .clearHistory();
    }

    @Override
    protected void setFirstOperand(String operand) {
        mathModel.setFirstOperand(operand);
    }

    @Override
    protected void setSecondOperand(String operand) {
        mathModel.setSecondOperand(operand);
    }

    @Override
    protected void setOperation(String operation) {
        mathModel.setOperation(operation);
    }

    @Override
    protected void setOnFlyMode(boolean isOnFlyMode) {
        mathModel.setOnFlyMode(isOnFlyMode);
    }

}
