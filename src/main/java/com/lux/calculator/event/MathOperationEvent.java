package com.lux.calculator.event;

import java.util.EventObject;

import com.lux.calculator.operation.MathOperationType;

public class MathOperationEvent extends EventObject {

    private static final long serialVersionUID = 8444593259209900015L;

    private double firstOperand;
    private double secondOperand;
    private MathOperationType type;

    public MathOperationEvent(Object source, double firstOperand, double secondOperand, MathOperationType type) {
        super(source);

        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.type = type;
    }

    public double getFirstOperand() {
        return firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public MathOperationType getType() {
        return type;
    }

}
