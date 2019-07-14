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

    private boolean isOnFlyMode;
    private boolean isPressedBtnCalculate;

    private String sign;

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
        if (!isValid())
            return;
        for (MathModelChangeListener observer : listeners) {
            observer.update(event);
        }
    }

    public void setFirstOperand(String firstOperand) {
        this.firstOperand = firstOperand;
        if (isValid()) {
            MathOperationEvent event = new MathOperationEvent(this, Double.parseDouble(firstOperand),
                    Double.parseDouble(secondOperand), MathOperationType.valueOf(sign));
            notifyObservers(event);
        }
    }

    public void setSecondOperand(String secondOperand) {
        this.secondOperand = secondOperand;
        if (isValid()) {
            MathOperationEvent event = new MathOperationEvent(this, Double.parseDouble(firstOperand),
                    Double.parseDouble(secondOperand), MathOperationType.valueOf(sign));
            notifyObservers(event);
        }
    }

    public void setSign(String sign) {
        this.sign = sign;
        if (isValid()) {
            System.err.println("### MathOperationType.valueOf(sign) = " + MathOperationType.valueOf(sign));
            MathOperationEvent event = new MathOperationEvent(this, Double.parseDouble(firstOperand),
                    Double.parseDouble(secondOperand), MathOperationType.valueOf(sign));
            notifyObservers(event);
        }
    }

    public boolean isOnFlyMode() {
        return isOnFlyMode;
    }

    public void setOnFlyMode(boolean isOnFlyMode) {
        this.isOnFlyMode = isOnFlyMode;
        if (isValid()) {
            MathOperationEvent event = new MathOperationEvent(this, Double.parseDouble(firstOperand),
                    Double.parseDouble(secondOperand), MathOperationType.valueOf(sign));
            notifyObservers(event);
        }
    }

    public void setPressedBtnCalculate(boolean isPressedBtnCalculate) {
        this.isPressedBtnCalculate = isPressedBtnCalculate;
        if (isValid()) {
            MathOperationEvent event = new MathOperationEvent(this, Double.parseDouble(firstOperand),
                    Double.parseDouble(secondOperand), MathOperationType.valueOf(sign));
            notifyObservers(event);
        }
    }

    private boolean isValid() {
        if (firstOperand != null && secondOperand != null && sign != null) {
            return true;
        } else
            return false;
    }

}
