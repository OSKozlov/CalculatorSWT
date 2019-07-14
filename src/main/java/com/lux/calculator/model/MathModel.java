package com.lux.calculator.model;

import java.util.LinkedList;
import java.util.List;

import com.lux.calculator.event.MathOperationEvent;
import com.lux.calculator.listener.MathModelChangeListener;
import com.lux.calculator.operation.MathOperationType;

public class MathModel {

    private List<MathModelChangeListener> listeners;

    private String firstOperand;
    private String secondOperand;

    private boolean isOnFlyMode = false;

    private String operation;

    private static MathModel instance;

    private MathModel() {
        listeners = new LinkedList<>();
    }

    public static MathModel getInstance() {
        if (instance == null) {
            instance = new MathModel();
        }
        return instance;
    }

    public void addMathModelChangeListener(MathModelChangeListener o) {
        listeners.add(o);
    }

    public void removeMathModelChangeListener(MathModelChangeListener o) {
        listeners.remove(o);
    }

    public void notifyObservers(MathOperationEvent event) {
        for (MathModelChangeListener observer : listeners) {
            observer.update(event);
        }
    }

    public void setFirstOperand(String firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(String secondOperand) {
        this.secondOperand = secondOperand;
    }

    public void setOperation(String sign) {
        this.operation = sign;
    }

    public boolean isOnFlyMode() {
        return isOnFlyMode;
    }

    public void setOnFlyMode(boolean isOnFlyMode) {
        this.isOnFlyMode = isOnFlyMode;
    }

    public void runCalculation() {
        if (isMathDataValid()) {
            MathOperationEvent event = new MathOperationEvent(this, Double.parseDouble(firstOperand),
                    Double.parseDouble(secondOperand), MathOperationType.valueOf(operation));
            notifyObservers(event);
        }
    }

    public boolean isMathDataValid() {
        if (firstOperand != null && secondOperand != null && operation != null) {
            return true;
        } else
            return false;
    }

}
