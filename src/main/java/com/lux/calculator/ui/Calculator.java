package com.lux.calculator.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import com.lux.calculator.event.MathOperationEvent;
import com.lux.calculator.listener.MathModelChangeListener;
import com.lux.calculator.model.MathModel;
import com.lux.calculator.operation.MathOperation;
import com.lux.calculator.operation.MathOperationAddition;
import com.lux.calculator.operation.MathOperationDevision;
import com.lux.calculator.operation.MathOperationMultiplication;
import com.lux.calculator.operation.MathOperationSubtraction;
import com.lux.calculator.operation.MathOperationType;

public class Calculator extends AbstractCalculator implements MathModelChangeListener {

    private MathModel mathModel;
    private CalculatorComposite calculatorComposite;

    protected Map<String, MathOperation> mathOperationsMap = new HashMap<>();

    private static Calculator instance;

    private Logger logger = Logger.getLogger(Calculator.class.getName());

    {
        mathOperationsMap.put(MathOperationType.ADDITION.getValue(), new MathOperationAddition());
        mathOperationsMap.put(MathOperationType.SUBTRACTION.getValue(), new MathOperationSubtraction());
        mathOperationsMap.put(MathOperationType.DIVISION.getValue(), new MathOperationDevision());
        mathOperationsMap.put(MathOperationType.MULTIPLICATION.getValue(), new MathOperationMultiplication());
    }

    private Calculator() {
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
            logger.log(Level.WARNING, "User input an invalid sign");
        }

        return mathOperation.calculateResult(firstNumber, secondNumber);
    }

    @Override
    public void runUI(Shell shell) {
        calculatorComposite = new CalculatorComposite(shell);
    }

    @Override
    public void update(MathOperationEvent event) {

        double firstOp = event.getFirstOperand();
        double secondOp = event.getSecondOperand();
        MathOperationType mathOpType = event.getType();

        double result = performOperation(firstOp, secondOp, mathOpType);

        displayOperationResult(String.valueOf(result));

        String expession = new StringBuilder().append(firstOp)
                                              .append(" ")
                                              .append(mathOpType.getOperationSign())
                                              .append(" ")
                                              .append(secondOp)
                                              .append("=")
                                              .append(result)
                                              .toString();

        displayExpressionInHistory(expession);
    }

    @Override
    protected void displayOperationResult(String result) {
        calculatorComposite.getMathOperationPanel()
                           .updateResultField(result);
    }

    @Override
    protected void displayExpressionInHistory(String stringExpression) {
        calculatorComposite.getHistoryPanel()
                           .addStatementToHistory(stringExpression);
    }

    @Override
    public void clearOperationHistory() {
        calculatorComposite.getHistoryPanel()
                           .clearHistory();
    }

    @Override
    public void setFirstOperand(String operand) {
        mathModel.setFirstOperand(operand);
    }

    @Override
    public void setSecondOperand(String operand) {
        mathModel.setSecondOperand(operand);
    }

    @Override
    public void setOperation(String operation) {
        mathModel.setOperation(operation);
    }

    @Override
    public void setOnFlyMode(boolean isOnFlyMode) {
        mathModel.setOnFlyMode(isOnFlyMode);
    }

    @Override
    public boolean isOnFlyMode() {
        return mathModel.isOnFlyMode();
    }

    @Override
    public void runCalculation() {
        mathModel.runCalculation();
    }

    @Override
    public boolean isDataFieldsValid() {
        return mathModel.isMathDataValid();
    }

    @Override
    public void displayMessage(Shell shell, int style, String title, String msg) {
        MessageBox messageBox = new MessageBox(shell, style);
        messageBox.setText(title);
        messageBox.setMessage(msg);
        messageBox.open();
    }

}
